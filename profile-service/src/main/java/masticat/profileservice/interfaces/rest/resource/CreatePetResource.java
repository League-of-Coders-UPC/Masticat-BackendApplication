package masticat.profileservice.interfaces.rest.resource;

import java.util.Date;

public record CreatePetResource(String name, String species, String breed, Date birthDate, Float weight) {
}
