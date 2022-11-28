package pl.ship.crew_ship.ship.entity.event.dto;

import lombok.*;
import pl.ship.crew_ship.dto.GetShipResponse;
import pl.ship.crew_ship.ship.entity.Ship;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateShipRequest {
    private Integer id;

    public static Function<Ship, CreateShipRequest> entityToDtoMapper() {
        return ship ->CreateShipRequest.builder()
                .id(ship.getId()).build();
    }
}
