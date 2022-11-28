package pl.ship.crew_ship.dto;

import lombok.*;
import pl.ship.crew_ship.ship.entity.Ship;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateShipRequest {
    private Integer id;
    private String name;
    private double length;

    public static Function<CreateShipRequest, Ship> dtoToEntityMapper(
            Function<Integer,Ship> shipFunction){
        return request -> Ship.builder()
                .id(request.id).build();

    }
}
