package masticat.petservice.domain.model.commands;
import masticat.petservice.domain.model.valueobjects.Species;

import java.util.Date;

public record CreatePetCommand(String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
