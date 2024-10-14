package masticat.profileservice.interfaces.rest.resource;

import java.util.Date;

public record PetResource(String uuid, String name, String species, String breed, Date birthDate, Float weight) {
}
