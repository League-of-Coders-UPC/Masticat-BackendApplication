package masticat.iamservice.interfaces.rest.transform;


import masticat.iamservice.domain.model.commands.UpdateUserCommand;
import masticat.iamservice.interfaces.rest.resource.UpdateUserResource;

public class UpdateUserCommandFromResourceAssembler {
    public static UpdateUserCommand toCommandFromResource(String uuid, UpdateUserResource resource) {
        return new UpdateUserCommand(uuid, resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
