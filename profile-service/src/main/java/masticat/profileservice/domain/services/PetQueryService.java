package masticat.profileservice.domain.services;

import masticat.profileservice.domain.model.entities.Pet;
import masticat.profileservice.domain.model.queries.GetAllPetsQuery;
import masticat.profileservice.domain.model.queries.GetPetByUuidQuery;

import java.util.List;
import java.util.Optional;

public interface PetQueryService {
    List<Pet> handle(GetAllPetsQuery query);

    Optional<Pet> handle(GetPetByUuidQuery query);
}
