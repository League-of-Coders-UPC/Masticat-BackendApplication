package masticat.profileservice.application.internal.commandservices;

import masticat.profileservice.domain.model.commands.CreatePetCommand;
import masticat.profileservice.domain.model.commands.UpdatePetCommand;
import masticat.profileservice.domain.model.entities.Pet;
import masticat.profileservice.domain.services.PetCommandService;
import masticat.profileservice.infrastructure.persistence.jpa.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetCommandServiceImpl implements PetCommandService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public String handle(CreatePetCommand command) {
        Pet pet = new Pet(command.name(), command.species(), command.breed(), command.birthDate(), command.weight());
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
        petRepository.save(petToUpdate);
        return Optional.of(petToUpdate);
    }
}
