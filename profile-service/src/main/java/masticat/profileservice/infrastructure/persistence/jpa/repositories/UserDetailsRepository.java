package masticat.profileservice.infrastructure.persistence.jpa.repositories;

import masticat.profileservice.domain.model.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
    Optional<UserDetails> findByUuid(String uuid);
}
