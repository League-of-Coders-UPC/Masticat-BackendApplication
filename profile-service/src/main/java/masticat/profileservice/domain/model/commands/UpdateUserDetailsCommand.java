package masticat.profileservice.domain.model.commands;

import masticat.profileservice.domain.model.valueobjects.Species;

import java.util.Date;

public record UpdateUserDetailsCommand(String uuid, String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
}
