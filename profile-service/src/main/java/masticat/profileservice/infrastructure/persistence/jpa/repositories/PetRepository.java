package masticat.profileservice.infrastructure.persistence.jpa.repositories;

import masticat.profileservice.domain.model.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {
    Optional<Pet> findByUuid(String uuid);
}
