package pl.kamol84.giveawaystuff.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToMany
    private Collection<User> users;

    public Role(String name) {
        this.name = name;
    }
}
