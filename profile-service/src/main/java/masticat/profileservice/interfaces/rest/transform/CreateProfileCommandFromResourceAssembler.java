package masticat.profileservice.interfaces.rest.transform;

import masticat.profileservice.domain.model.commands.CreateProfileCommand;
import masticat.profileservice.interfaces.rest.resource.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
