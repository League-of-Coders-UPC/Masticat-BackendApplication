package masticat.profileservice.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import masticat.profileservice.domain.model.valueobjects.Species;

import java.util.ArrayList;
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

    @Enumerated(EnumType.STRING)
    private Species species;

    private String breed;

    private Date birthDate;

    private Float weight;

    @ManyToMany(mappedBy = "pets")
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    public Pet(){}

    public Pet(String name, Species species, String breed, Date birthDate, Float weight, List<User> users) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.birthDate = birthDate;
        this.weight = weight;
        this.users = users;
    }
}
