package masticat.petservice.application.internal.queryservices;

import masticat.petservice.domain.model.entities.Pet;
import masticat.petservice.domain.model.queries.GetAllPetsQuery;
import masticat.petservice.domain.model.queries.GetPetByUuidQuery;
import masticat.petservice.domain.services.PetQueryService;
import masticat.petservice.infrastructure.persistence.jpa.repositories.PetRepository;
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
