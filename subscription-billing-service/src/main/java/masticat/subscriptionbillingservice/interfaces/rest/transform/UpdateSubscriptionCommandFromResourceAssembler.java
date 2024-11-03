package masticat.subscriptionbillingservice.interfaces.rest.transform;


import masticat.subscriptionbillingservice.domain.model.commands.UpdateSubscriptionCommand;
import masticat.subscriptionbillingservice.interfaces.rest.resource.UpdateSubscriptionResource;

public class UpdateSubscriptionCommandFromResourceAssembler {
    public static UpdateSubscriptionCommand toCommandFromResource(String uuid, UpdateSubscriptionResource resource) {
        return new UpdateSubscriptionCommand(uuid, resource.name(), resource.userUuid(), resource.species(), resource.breed(), resource.birthDate(), resource.age(), resource.weight(), resource.imageUrl());
    }
}
