package masticat.profileservice.domain.model.commands;

import masticat.profileservice.domain.model.valueobjects.Species;

import java.util.Date;
import java.util.List;

public record UpdatePetCommand(String uuid, String name, Species species, String breed, Date birthDate, Float weight, List<String> ownersUuids) {
}
