package masticat.subscriptionbillingservice.interfaces.rest.transform;

import masticat.subscriptionbillingservice.domain.model.commands.CreateSubscriptionCommand;
import masticat.subscriptionbillingservice.interfaces.rest.resource.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {
    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
