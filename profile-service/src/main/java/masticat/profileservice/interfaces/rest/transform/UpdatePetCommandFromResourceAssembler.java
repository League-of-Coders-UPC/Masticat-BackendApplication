package masticat.profileservice.interfaces.rest.transform;


import masticat.profileservice.domain.model.commands.UpdatePetCommand;
import masticat.profileservice.interfaces.rest.resource.UpdatePetResource;

public class UpdatePetCommandFromResourceAssembler {
    public static UpdatePetCommand toCommandFromResource(String uuid, UpdatePetResource resource) {
        return new UpdatePetCommand(uuid, resource.name(), resource.species(), resource.breed(), resource.birthDate(), resource.weight());
    }
}
