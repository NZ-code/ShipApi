package pl.ship.crew_ship.dto;


import lombok.*;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.ship.entity.Ship;

import javax.persistence.Id;
import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateHumanRequest {

    private String name;
    private int age;

    public static BiFunction<Human,UpdateHumanRequest, Human> dtoToEntityMapper(
            Ship ship
    ){
        return (human,request)-> {
            human.setName(request.name);
                    human.setAge(request.age);
                    human.setShip(ship);
                    return human;
        };

    };
}
