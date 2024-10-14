package masticat.profileservice.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    private String species;

    private String breed;

    private Date birthDate;

    private Float weight;

    @ManyToMany
    private List<User> owners;

    public Pet(){}

    public Pet(String name, String species, String breed, Date birthDate, Float weight) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.birthDate = birthDate;
        this.weight = weight;
    }
}
