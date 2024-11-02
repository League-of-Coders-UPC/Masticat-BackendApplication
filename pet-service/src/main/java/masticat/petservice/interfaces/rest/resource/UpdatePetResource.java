package masticat.petservice.interfaces.rest.resource;

import masticat.petservice.domain.model.valueobjects.Species;

import java.util.Date;

public record UpdatePetResource(String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
