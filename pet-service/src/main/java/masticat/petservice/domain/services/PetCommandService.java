package masticat.petservice.domain.services;

import masticat.petservice.domain.model.commands.CreatePetCommand;
import masticat.petservice.domain.model.commands.UpdatePetCommand;
import masticat.petservice.domain.model.entities.Pet;

import java.util.Optional;

public interface PetCommandService {
    String handle(CreatePetCommand command);

    Optional<Pet> handle(UpdatePetCommand command);
}
