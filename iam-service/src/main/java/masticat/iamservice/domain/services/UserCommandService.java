package masticat.iamservice.domain.services;

import masticat.iamservice.domain.model.commands.CreateUserCommand;
import masticat.iamservice.domain.model.commands.UpdateUserCommand;
import masticat.iamservice.domain.model.entities.User;

import java.util.Optional;

public interface UserCommandService {
    String handle(CreateUserCommand command);

    Optional<User> handle(UpdateUserCommand command);
}
