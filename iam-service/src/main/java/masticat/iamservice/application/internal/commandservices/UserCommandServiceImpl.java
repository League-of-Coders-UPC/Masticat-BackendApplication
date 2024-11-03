package masticat.iamservice.application.internal.commandservices;

import masticat.iamservice.domain.model.commands.CreateUserCommand;
import masticat.iamservice.domain.model.commands.UpdateUserCommand;
import masticat.iamservice.domain.model.entities.User;
import masticat.iamservice.domain.services.UserCommandService;
import masticat.iamservice.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserRepository userRepository;

    //TODO: add user validation with jwt
    @Override
    public String handle(CreateUserCommand command) {
        User user = new User(command.name(),command.userUuid(), command.species(), command.breed(), command.birthDate(), command.age(),command.weight(), command.imageUrl());
        userRepository.save(user);
        return user.getUuid();
    }

    //TODO: add user validation
    @Override
    public Optional<User> handle(UpdateUserCommand command) {
        User userToUpdate = userRepository.findByUuid(command.uuid()).orElseThrow(() -> new RuntimeException("User not found"));
        userToUpdate.setName(command.name());
        userToUpdate.setUserUuid(command.userUuid());
        userToUpdate.setSpecies(command.species());
        userToUpdate.setBreed(command.breed());
        userToUpdate.setBirthDate(command.birthDate());
        userToUpdate.setAge(command.age());
        userToUpdate.setWeight(command.weight());
        userRepository.save(userToUpdate);
        return Optional.of(userToUpdate);
    }
}
