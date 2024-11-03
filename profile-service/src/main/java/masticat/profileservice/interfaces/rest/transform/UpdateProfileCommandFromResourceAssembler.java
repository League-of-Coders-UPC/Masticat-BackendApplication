package masticat.profileservice.interfaces.rest.transform;


import masticat.profileservice.domain.model.commands.UpdateProfileCommand;
import masticat.profileservice.interfaces.rest.resource.UpdateProfileResource;

public class UpdateProfileCommandFromResourceAssembler {
    public static UpdateProfileCommand toCommandFromResource(String uuid, UpdateProfileResource resource) {
        return new UpdateProfileCommand(uuid, resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
