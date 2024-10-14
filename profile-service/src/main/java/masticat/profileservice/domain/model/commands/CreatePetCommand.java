package masticat.profileservice.domain.model.commands;
import java.util.Date;

public record CreatePetCommand(String name, String species, String breed, Date birthDate, Float weight) {
}
