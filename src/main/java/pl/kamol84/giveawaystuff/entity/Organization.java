package pl.kamol84.giveawaystuff.entity;

import lombok.Data;
import pl.kamol84.giveawaystuff.enums.GiftCategory;
import pl.kamol84.giveawaystuff.enums.GiftForWhom;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "organization")
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @ManyToOne
    private City city;

    @NotBlank
    private String goals;

    @ElementCollection(targetClass = GiftCategory.class)
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Set<GiftCategory> categories;

    @ElementCollection(targetClass = GiftForWhom.class)
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Set<GiftForWhom> forWhom;
}
