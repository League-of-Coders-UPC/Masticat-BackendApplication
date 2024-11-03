package masticat.profileservice.application.internal.commandservices;

import masticat.profileservice.domain.model.commands.CreateUserDetailsCommand;
import masticat.profileservice.domain.model.commands.UpdateUserDetailsCommand;
import masticat.profileservice.domain.model.entities.UserDetails;
import masticat.profileservice.domain.services.UserDetailsCommandService;
import masticat.profileservice.infrastructure.persistence.jpa.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsCommandServiceImpl implements UserDetailsCommandService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    //TODO: add user validation with jwt
    @Override
    public String handle(CreateUserDetailsCommand command) {
        UserDetails userDetails = new UserDetails(command.name(),command.userUuid(), command.species(), command.breed(), command.birthDate(), command.age(),command.weight(), command.imageUrl());
        userDetailsRepository.save(userDetails);
        return userDetails.getUuid();
    }

    //TODO: add user validation
    @Override
    public Optional<UserDetails> handle(UpdateUserDetailsCommand command) {
        UserDetails userDetailsToUpdate = userDetailsRepository.findByUuid(command.uuid()).orElseThrow(() -> new RuntimeException("UserDetails not found"));
        userDetailsToUpdate.setName(command.name());
        userDetailsToUpdate.setUserUuid(command.userUuid());
        userDetailsToUpdate.setSpecies(command.species());
        userDetailsToUpdate.setBreed(command.breed());
        userDetailsToUpdate.setBirthDate(command.birthDate());
        userDetailsToUpdate.setAge(command.age());
        userDetailsToUpdate.setWeight(command.weight());
        userDetailsRepository.save(userDetailsToUpdate);
        return Optional.of(userDetailsToUpdate);
    }
}
