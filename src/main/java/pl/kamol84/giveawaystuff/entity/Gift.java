package pl.kamol84.giveawaystuff.entity;

import lombok.Data;
import pl.kamol84.giveawaystuff.enums.GiftCategory;
import pl.kamol84.giveawaystuff.enums.GiftCity;
import pl.kamol84.giveawaystuff.enums.GiftForWhom;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "gift")
@Data
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private GiftCategory category;

    @Min(0)
    private Integer numberOfBag;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private GiftCity city; //TODO: leave Enum or change to entity?

    @Enumerated(EnumType.STRING)
    @NotBlank
    private GiftForWhom forWhom;

    private String addres; //TODO: make model/entity for address

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
