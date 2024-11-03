package masticat.subscriptionbillingservice.application.internal.queryservices;

import masticat.subscriptionbillingservice.domain.model.entities.Subscription;
import masticat.subscriptionbillingservice.domain.model.queries.GetAllSubscriptionsQuery;
import masticat.subscriptionbillingservice.domain.model.queries.GetSubscriptionByUuidQuery;
import masticat.subscriptionbillingservice.domain.services.SubscriptionQueryService;
import masticat.subscriptionbillingservice.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> handle(GetAllSubscriptionsQuery query) {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByUuidQuery query) {
        return subscriptionRepository.findByUuid(query.uuid());
    }
}
