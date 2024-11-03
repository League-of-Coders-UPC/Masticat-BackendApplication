package masticat.iamservice.domain.services;

import masticat.iamservice.domain.model.entities.User;
import masticat.iamservice.domain.model.queries.GetAllUsersQuery;
import masticat.iamservice.domain.model.queries.GetUserByUuidQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);

    Optional<User> handle(GetUserByUuidQuery query);
}
