package pl.ship.crew_ship.dto;

import lombok.*;
import pl.ship.crew_ship.ship.entity.Ship;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetShipsResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    private static class Ship{
        private Integer id;
        private String name;
        private double length;
    }

    private List<Ship> ships;
    public static Function<Collection<pl.ship.crew_ship.ship.entity.Ship>,GetShipsResponse> entityToDtoMapper(){
        return entityShips ->{
            var shipList = entityShips.stream().map(entityShip->
                    Ship.builder()
                            .id(entityShip.getId())
                            .length(entityShip.getLength())
                            .name(entityShip.getName())
                            .build()
            ).toList();
            return new GetShipsResponse(shipList);
        };
    }
}
