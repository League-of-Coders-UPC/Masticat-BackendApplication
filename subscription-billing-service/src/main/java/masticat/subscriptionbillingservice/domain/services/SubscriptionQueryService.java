package masticat.subscriptionbillingservice.domain.services;

import masticat.subscriptionbillingservice.domain.model.entities.Subscription;
import masticat.subscriptionbillingservice.domain.model.queries.GetAllSubscriptionsQuery;
import masticat.subscriptionbillingservice.domain.model.queries.GetSubscriptionByUuidQuery;

import java.util.List;
import java.util.Optional;

public interface SubscriptionQueryService {
    List<Subscription> handle(GetAllSubscriptionsQuery query);

    Optional<Subscription> handle(GetSubscriptionByUuidQuery query);
}
