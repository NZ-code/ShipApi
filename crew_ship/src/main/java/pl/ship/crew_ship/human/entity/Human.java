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
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "ship")
    private Ship ship;



}
