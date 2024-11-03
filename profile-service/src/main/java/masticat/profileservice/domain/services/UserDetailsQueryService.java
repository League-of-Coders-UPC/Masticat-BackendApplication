package masticat.profileservice.domain.services;

import masticat.profileservice.domain.model.entities.UserDetails;
import masticat.profileservice.domain.model.queries.GetAllUserDetailssQuery;
import masticat.profileservice.domain.model.queries.GetUserDetailsByUuidQuery;

import java.util.List;
import java.util.Optional;

public interface UserDetailsQueryService {
    List<UserDetails> handle(GetAllUserDetailssQuery query);

    Optional<UserDetails> handle(GetUserDetailsByUuidQuery query);
}
