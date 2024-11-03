package masticat.iamservice.application.internal.queryservices;

import masticat.iamservice.domain.model.entities.User;
import masticat.iamservice.domain.model.queries.GetAllUsersQuery;
import masticat.iamservice.domain.model.queries.GetUserByUuidQuery;
import masticat.iamservice.domain.services.UserQueryService;
import masticat.iamservice.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByUuidQuery query) {
        return userRepository.findByUuid(query.uuid());
    }
}
