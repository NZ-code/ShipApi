package pl.ship.crew_ship.dto;


import lombok.*;
import pl.ship.crew_ship.ship.entity.Ship;

import javax.persistence.Id;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class GetShipResponse {
    private Integer id;
    private String name;
    private double length;

    public static Function<Ship,GetShipResponse> entityToDtoMapper() {
        return ship ->{
          return GetShipResponse.builder()
                  .id(ship.getId())
                  .name(ship.getName())
                  .length(ship.getLength())
                  .build();
        };
    }
}
