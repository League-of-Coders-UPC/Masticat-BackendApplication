package masticat.iamservice.interfaces.rest.transform;

import masticat.iamservice.domain.model.entities.User;
import masticat.iamservice.interfaces.rest.resource.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user){
        return new UserResource(user.getUuid(), user.getName(), user.getUserUuid(), user.getSpecies(), user.getBreed(), user.getBirthDate(), user.getAge(), user.getWeight(), user.getImageUrl());
    }
}
