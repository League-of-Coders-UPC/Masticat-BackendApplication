package masticat.profileservice.interfaces.rest.resource;

import masticat.profileservice.domain.model.valueobjects.Species;

import java.util.Date;
import java.util.List;

public record CreatePetResource(String name, Species species, String breed, Date birthDate, Float weight, List<String> ownersUuids) {
}
