package masticat.subscriptionbillingservice.domain.services;

import masticat.subscriptionbillingservice.domain.model.commands.CreateSubscriptionCommand;
import masticat.subscriptionbillingservice.domain.model.commands.UpdateSubscriptionCommand;
import masticat.subscriptionbillingservice.domain.model.entities.Subscription;

import java.util.Optional;

public interface SubscriptionCommandService {
    String handle(CreateSubscriptionCommand command);

    Optional<Subscription> handle(UpdateSubscriptionCommand command);
}
