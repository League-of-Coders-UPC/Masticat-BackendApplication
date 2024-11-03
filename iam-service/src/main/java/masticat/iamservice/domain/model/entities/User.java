package masticat.iamservice.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import masticat.iamservice.domain.model.valueobjects.Species;

import java.util.Date;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    private String userUuid;

    @Enumerated(EnumType.STRING)
    private Species species;

    private String breed;

    private Date birthDate;

    private Long age;

    private Float weight;

    private String imageUrl;

    public User(){}

    public User(String name, String userUuid, Species species, String breed, Date birthDate, Long age, Float weight, String imageUrl) {
        this.name = name;
        this.userUuid = userUuid;
        this.species = species;
        this.breed = breed;
        this.birthDate = birthDate;
        this.age = age;
        this.weight = weight;
        this.imageUrl = imageUrl;
    }
}
