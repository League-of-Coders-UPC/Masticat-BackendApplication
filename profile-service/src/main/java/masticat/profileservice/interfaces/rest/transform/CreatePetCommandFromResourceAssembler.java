package masticat.profileservice.interfaces.rest.transform;

import masticat.profileservice.domain.model.commands.CreatePetCommand;
import masticat.profileservice.interfaces.rest.resource.CreatePetResource;

public class CreatePetCommandFromResourceAssembler {
    public static CreatePetCommand toCommandFromResource(CreatePetResource resource) {
        return new CreatePetCommand(resource.name(), resource.species(), resource.breed(), resource.birthDate(), resource.weight());
    }
}
