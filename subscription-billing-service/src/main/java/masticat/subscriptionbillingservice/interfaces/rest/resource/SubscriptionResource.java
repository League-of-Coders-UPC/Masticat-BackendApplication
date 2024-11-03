package masticat.subscriptionbillingservice.interfaces.rest.resource;

import masticat.subscriptionbillingservice.domain.model.valueobjects.Species;

import java.util.Date;

public record SubscriptionResource(String uuid, String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
