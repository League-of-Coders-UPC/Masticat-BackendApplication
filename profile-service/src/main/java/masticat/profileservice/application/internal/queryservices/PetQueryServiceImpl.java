package masticat.profileservice.application.internal.queryservices;

import masticat.profileservice.domain.model.entities.Pet;
import masticat.profileservice.domain.model.queries.GetAllPetsQuery;
import masticat.profileservice.domain.model.queries.GetPetByUuidQuery;
import masticat.profileservice.domain.services.PetQueryService;
import masticat.profileservice.infrastructure.persistence.jpa.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetQueryServiceImpl implements PetQueryService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> handle(GetAllPetsQuery query) {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> handle(GetPetByUuidQuery query) {
        return petRepository.findByUuid(query.uuid());
    }
}
