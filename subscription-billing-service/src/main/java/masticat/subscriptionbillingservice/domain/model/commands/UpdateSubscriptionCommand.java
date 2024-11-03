package masticat.subscriptionbillingservice.domain.model.commands;

import masticat.subscriptionbillingservice.domain.model.valueobjects.Species;

import java.util.Date;

public record UpdateSubscriptionCommand(String uuid, String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
