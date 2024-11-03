package masticat.iamservice.infrastructure.persistence.jpa.repositories;

import masticat.iamservice.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUuid(String uuid);
}
