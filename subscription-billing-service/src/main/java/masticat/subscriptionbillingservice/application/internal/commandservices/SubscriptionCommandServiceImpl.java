package masticat.subscriptionbillingservice.application.internal.commandservices;

import masticat.subscriptionbillingservice.domain.model.commands.CreateSubscriptionCommand;
import masticat.subscriptionbillingservice.domain.model.commands.UpdateSubscriptionCommand;
import masticat.subscriptionbillingservice.domain.model.entities.Subscription;
import masticat.subscriptionbillingservice.domain.services.SubscriptionCommandService;
import masticat.subscriptionbillingservice.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionCommandServiceImpl implements SubscriptionCommandService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    //TODO: add user validation with jwt
    @Override
    public String handle(CreateSubscriptionCommand command) {
        Subscription subscription = new Subscription(command.name(),command.userUuid(), command.species(), command.breed(), command.birthDate(), command.age(),command.weight(), command.imageUrl());
        subscriptionRepository.save(subscription);
        return subscription.getUuid();
    }

    //TODO: add user validation
    @Override
    public Optional<Subscription> handle(UpdateSubscriptionCommand command) {
        Subscription subscriptionToUpdate = subscriptionRepository.findByUuid(command.uuid()).orElseThrow(() -> new RuntimeException("Subscription not found"));
        subscriptionToUpdate.setName(command.name());
        subscriptionToUpdate.setUserUuid(command.userUuid());
        subscriptionToUpdate.setSpecies(command.species());
        subscriptionToUpdate.setBreed(command.breed());
        subscriptionToUpdate.setBirthDate(command.birthDate());
        subscriptionToUpdate.setAge(command.age());
        subscriptionToUpdate.setWeight(command.weight());
        subscriptionRepository.save(subscriptionToUpdate);
        return Optional.of(subscriptionToUpdate);
    }
}
