package masticat.petservice.interfaces.rest.transform;


import masticat.petservice.domain.model.commands.UpdatePetCommand;
import masticat.petservice.interfaces.rest.resource.UpdatePetResource;

public class UpdatePetCommandFromResourceAssembler {
    public static UpdatePetCommand toCommandFromResource(String uuid, UpdatePetResource resource) {
        return new UpdatePetCommand(uuid, resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
