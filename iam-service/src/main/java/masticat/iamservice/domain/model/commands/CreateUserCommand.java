package masticat.iamservice.domain.model.commands;
import masticat.iamservice.domain.model.valueobjects.Species;

import java.util.Date;

public record CreateUserCommand(String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
