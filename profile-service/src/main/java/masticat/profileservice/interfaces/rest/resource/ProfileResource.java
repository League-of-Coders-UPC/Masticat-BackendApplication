package masticat.profileservice.interfaces.rest.resource;

import masticat.profileservice.domain.model.valueobjects.Species;

import java.util.Date;

public record ProfileResource(String uuid, String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
