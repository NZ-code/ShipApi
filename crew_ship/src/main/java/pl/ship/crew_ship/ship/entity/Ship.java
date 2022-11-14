package pl.ship.crew_ship.ship.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.ship.crew_ship.human.entity.Human;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ships")
public class Ship {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double length;
    public Ship(String name, double length, List<Human> crew){
        this.name = name;
        this.length = length;
        this.crew = crew;

    }
    @OneToMany(mappedBy = "ship")
    @ToString.Exclude
    private List<Human> crew;

}
