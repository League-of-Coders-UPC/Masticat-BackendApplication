package masticat.petservice.domain.services;

import masticat.petservice.domain.model.entities.Pet;
import masticat.petservice.domain.model.queries.GetAllPetsQuery;
import masticat.petservice.domain.model.queries.GetPetByUuidQuery;

import java.util.List;
import java.util.Optional;

public interface PetQueryService {
    List<Pet> handle(GetAllPetsQuery query);

    Optional<Pet> handle(GetPetByUuidQuery query);
}
