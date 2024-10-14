package masticat.profileservice.domain.services;

import masticat.profileservice.domain.model.commands.CreatePetCommand;
import masticat.profileservice.domain.model.commands.UpdatePetCommand;
import masticat.profileservice.domain.model.entities.Pet;

import java.util.Optional;

public interface PetCommandService {
    String handle(CreatePetCommand command);

    Optional<Pet> handle(UpdatePetCommand command);
}
