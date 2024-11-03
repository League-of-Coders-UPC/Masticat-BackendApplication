package masticat.profileservice.interfaces.rest.resource;

import masticat.profileservice.domain.model.valueobjects.Species;

import java.util.Date;

public record UpdateProfileResource(String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
