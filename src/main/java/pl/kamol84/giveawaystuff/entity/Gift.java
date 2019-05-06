package pl.kamol84.giveawaystuff.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kamol84.giveawaystuff.enums.GiftCategory;
import pl.kamol84.giveawaystuff.enums.GiftForWhom;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "gift")
@Data
@NoArgsConstructor
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass = GiftCategory.class)
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Set<GiftCategory> categories;

    @Min(0)
    private Integer numberOfBag;

    @NotBlank
    @ManyToOne
    private City city;

    @ElementCollection(targetClass = GiftForWhom.class)
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Set<GiftForWhom> forWhom;

    @NotBlank
    @ManyToOne
    private Organization organization;

    private String address; //TODO: make entity for address

    @NotBlank
    @Future
    private LocalDate dateOfReceipt;

    @NotBlank
    private LocalTime timeOfReceipt;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    private User user;

}
