package pl.ship.crew_ship.human.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.ship.crew_ship.ship.entity.Ship;

import javax.persistence.*;

@SuperBuilder
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
@Table(name = "humans")
public class Human {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    public Human(String name, Integer age,Ship ship ){
        this.name = name;
        this.age = age;
        this.ship = ship;
    }
    @ManyToOne
    @JoinColumn(name = "ship")
    private Ship ship;



}
