package pl.ship.crew_ship.dto;

import lombok.*;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.ship.entity.Ship;

import javax.persistence.Id;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateHumanRequest {

    private Integer id;
    private String name;
    private int age;

    public static Function<CreateHumanRequest, Human> dtoToEntityMapper(
            Ship ship
    ){
        return request-> Human.builder()

                .name(request.name)
                .age(request.age)
                .ship(ship)
                .build();
    }
}
