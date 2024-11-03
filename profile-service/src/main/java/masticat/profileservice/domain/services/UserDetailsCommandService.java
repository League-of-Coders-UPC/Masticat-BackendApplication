package masticat.profileservice.domain.services;

import masticat.profileservice.domain.model.commands.CreateUserDetailsCommand;
import masticat.profileservice.domain.model.commands.UpdateUserDetailsCommand;
import masticat.profileservice.domain.model.entities.UserDetails;

import java.util.Optional;

public interface UserDetailsCommandService {
    String handle(CreateUserDetailsCommand command);

    Optional<UserDetails> handle(UpdateUserDetailsCommand command);
}
