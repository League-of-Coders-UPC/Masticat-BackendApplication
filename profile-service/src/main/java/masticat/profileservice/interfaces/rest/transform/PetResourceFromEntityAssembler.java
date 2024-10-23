package masticat.profileservice.interfaces.rest.transform;

import masticat.profileservice.domain.model.entities.Pet;
import masticat.profileservice.interfaces.rest.resource.PetResource;

public class PetResourceFromEntityAssembler {
    public static PetResource toResourceFromEntity(Pet pet){
        return new PetResource(pet.getUuid(), pet.getName(), pet.getSpecies(), pet.getBreed(), pet.getBirthDate(), pet.getWeight(), pet.getUsers());
    }
}
