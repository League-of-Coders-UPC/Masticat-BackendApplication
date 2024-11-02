package masticat.petservice.application.internal.commandservices;

import masticat.petservice.domain.model.commands.CreatePetCommand;
import masticat.petservice.domain.model.commands.UpdatePetCommand;
import masticat.petservice.domain.model.entities.Pet;
import masticat.petservice.domain.services.PetCommandService;
import masticat.petservice.infrastructure.persistence.jpa.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetCommandServiceImpl implements PetCommandService {

    @Autowired
    private PetRepository petRepository;

    //TODO: add user validation with jwt
    @Override
    public String handle(CreatePetCommand command) {
        Pet pet = new Pet(command.name(),command.userUuid(), command.species(), command.breed(), command.birthDate(), command.age(),command.weight(), command.imageUrl());
        petRepository.save(pet);
        return pet.getUuid();
    }

    //TODO: add user validation
    @Override
    public Optional<Pet> handle(UpdatePetCommand command) {
        Pet petToUpdate = petRepository.findByUuid(command.uuid()).orElseThrow(() -> new RuntimeException("Pet not found"));
        petToUpdate.setName(command.name());
        petToUpdate.setUserUuid(command.userUuid());
        petToUpdate.setSpecies(command.species());
        petToUpdate.setBreed(command.breed());
        petToUpdate.setBirthDate(command.birthDate());
        petToUpdate.setAge(command.age());
        petToUpdate.setWeight(command.weight());
        petRepository.save(petToUpdate);
        return Optional.of(petToUpdate);
    }
}
