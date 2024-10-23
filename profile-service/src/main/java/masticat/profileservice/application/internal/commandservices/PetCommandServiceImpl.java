package masticat.profileservice.application.internal.commandservices;

import masticat.profileservice.domain.model.commands.CreatePetCommand;
import masticat.profileservice.domain.model.commands.UpdatePetCommand;
import masticat.profileservice.domain.model.entities.Pet;
import masticat.profileservice.domain.model.entities.User;
import masticat.profileservice.domain.services.PetCommandService;
import masticat.profileservice.infrastructure.persistence.jpa.repositories.PetRepository;
import masticat.profileservice.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetCommandServiceImpl implements PetCommandService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String handle(CreatePetCommand command) {
        List<User> owners = new ArrayList<>();
        for(String ownerUuid : command.ownersUuids()){
            User owner = userRepository.findByUuid(ownerUuid).orElseThrow(() -> new RuntimeException("User not found"));
            owners.add(owner);
        }
        Pet pet = new Pet(command.name(), command.species(), command.breed(), command.birthDate(), command.weight(), owners);
        petRepository.save(pet);
        return pet.getUuid();
    }

    @Override
    public Optional<Pet> handle(UpdatePetCommand command) {
        Pet petToUpdate = petRepository.findByUuid(command.uuid()).orElseThrow(() -> new RuntimeException("Pet not found"));
        petToUpdate.setName(command.name());
        petToUpdate.setSpecies(command.species());
        petToUpdate.setBreed(command.breed());
        petToUpdate.setBirthDate(command.birthDate());
        petToUpdate.setWeight(command.weight());
        List<User> owners = new ArrayList<>();
        for(String ownerUuid : command.ownersUuids()){
            User owner = userRepository.findByUuid(ownerUuid).orElseThrow(() -> new RuntimeException("User not found"));
            owners.add(owner);
        }
        petToUpdate.setUsers(owners);
        petRepository.save(petToUpdate);
        return Optional.of(petToUpdate);
    }
}
