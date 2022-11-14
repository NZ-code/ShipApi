package pl.ship.crew_ship.dto;

import lombok.*;
import pl.ship.crew_ship.human.entity.Human;

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
public class GetHumansResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    private static class Human{
        private Integer id;
        private String name;
        private int age;
    }

    private List<Human> ships;
    public static Function<Collection<pl.ship.crew_ship.human.entity.Human>, GetHumansResponse> entityToDtoMapper(){
        return entityHumans ->{
            var humansList = entityHumans.stream().map(entityShip->
                    Human.builder()
                            .id(entityShip.getId())
                            .age(entityShip.getAge())
                            .name(entityShip.getName())
                            .build()
            ).toList();
            return new GetHumansResponse(humansList);
        };
    }
}
