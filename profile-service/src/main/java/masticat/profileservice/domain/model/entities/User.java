package masticat.profileservice.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    private String email;

    private Long phoneNumber;

    private String address;

    private Date birthDate;

    @ManyToMany
    private List<Pet> pets;
}
