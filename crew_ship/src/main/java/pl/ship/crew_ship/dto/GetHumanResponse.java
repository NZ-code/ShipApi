package pl.ship.crew_ship.dto;

import lombok.*;
import pl.ship.crew_ship.human.entity.Human;

import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetHumanResponse {
    private Integer id;
    private String name;
    private int age;
    public static Function<Human, GetHumanResponse> entityToDtoMapper(){
        return human -> new GetHumanResponse(human.getId(), human.getName(), human.getAge()
        );
    }
}
