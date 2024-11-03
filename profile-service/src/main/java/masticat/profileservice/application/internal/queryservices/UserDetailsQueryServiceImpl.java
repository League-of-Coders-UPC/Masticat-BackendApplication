package masticat.profileservice.application.internal.queryservices;

import masticat.profileservice.domain.model.entities.UserDetails;
import masticat.profileservice.domain.model.queries.GetAllUserDetailssQuery;
import masticat.profileservice.domain.model.queries.GetUserDetailsByUuidQuery;
import masticat.profileservice.domain.services.UserDetailsQueryService;
import masticat.profileservice.infrastructure.persistence.jpa.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsQueryServiceImpl implements UserDetailsQueryService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public List<UserDetails> handle(GetAllUserDetailssQuery query) {
        return userDetailsRepository.findAll();
    }

    @Override
    public Optional<UserDetails> handle(GetUserDetailsByUuidQuery query) {
        return userDetailsRepository.findByUuid(query.uuid());
    }
}
