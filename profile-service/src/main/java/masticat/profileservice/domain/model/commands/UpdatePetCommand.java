package masticat.profileservice.domain.model.commands;

import java.util.Date;

public record UpdatePetCommand(String uuid, String name, String species, String breed, Date birthDate, Float weight) {
}
