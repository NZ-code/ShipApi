package pl.ship.crew_ship.ship.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.ship.crew_ship.human.entity.Human;

import javax.persistence.*;
import java.util.List;

@ToString
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
@Table(name="ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
    private double length;


    @OneToMany(mappedBy = "ship")
    @ToString.Exclude
    private List<Human> crew;

}
