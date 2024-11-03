package masticat.subscriptionbillingservice.interfaces.rest.transform;

import masticat.subscriptionbillingservice.domain.model.entities.Subscription;
import masticat.subscriptionbillingservice.interfaces.rest.resource.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {
    public static SubscriptionResource toResourceFromEntity(Subscription subscription){
        return new SubscriptionResource(subscription.getUuid(), subscription.getName(), subscription.getUserUuid(), subscription.getSpecies(), subscription.getBreed(), subscription.getBirthDate(), subscription.getAge(), subscription.getWeight(), subscription.getImageUrl());
    }
}
