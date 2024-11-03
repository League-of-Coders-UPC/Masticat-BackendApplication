package masticat.iamservice.interfaces.rest.transform;

import masticat.iamservice.domain.model.commands.CreateUserCommand;
import masticat.iamservice.interfaces.rest.resource.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
