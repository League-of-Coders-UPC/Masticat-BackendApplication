package masticat.profileservice.interfaces.rest.transform;

import masticat.profileservice.domain.model.entities.Profile;
import masticat.profileservice.interfaces.rest.resource.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile profile){
        return new ProfileResource(profile.getUuid(), profile.getName(), profile.getUserUuid(), profile.getSpecies(), profile.getBreed(), profile.getBirthDate(), profile.getAge(), profile.getWeight(), profile.getImageUrl());
    }
}
