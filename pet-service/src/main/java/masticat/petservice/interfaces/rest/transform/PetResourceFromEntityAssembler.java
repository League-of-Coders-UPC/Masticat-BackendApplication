package masticat.petservice.interfaces.rest.transform;

import masticat.petservice.domain.model.entities.Pet;
import masticat.petservice.interfaces.rest.resource.PetResource;

public class PetResourceFromEntityAssembler {
    public static PetResource toResourceFromEntity(Pet pet){
        return new PetResource(pet.getUuid(), pet.getName(), pet.getUserUuid(), pet.getSpecies(), pet.getBreed(), pet.getBirthDate(), pet.getAge(), pet.getWeight(), pet.getImageUrl());
    }
}
