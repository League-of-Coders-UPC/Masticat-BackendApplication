package masticat.iamservice.interfaces.rest.resource;

import masticat.iamservice.domain.model.valueobjects.Species;

import java.util.Date;

public record UserResource(String uuid, String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
