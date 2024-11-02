package masticat.petservice.interfaces.rest.transform;

import masticat.petservice.domain.model.commands.CreatePetCommand;
import masticat.petservice.interfaces.rest.resource.CreatePetResource;

public class CreatePetCommandFromResourceAssembler {
    public static CreatePetCommand toCommandFromResource(CreatePetResource resource) {
        return new CreatePetCommand(resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
