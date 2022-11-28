package pl.ship.crew_ship.dto;

import lombok.*;
import pl.ship.crew_ship.ship.entity.Ship;

import java.util.function.BiFunction;
import java.util.function.Function;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateShipRequest {
    private String name;
    private double length;

    public static BiFunction<Ship,UpdateShipRequest, Ship> dtoToEntityUpdater(){
        return (ship,request) ->
        {
            ship.setName(request.name);
            ship.setLength(request.length);
            return ship;
        };
    }
}
