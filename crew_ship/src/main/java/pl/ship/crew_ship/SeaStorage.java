package pl.ship.crew_ship;

import org.springframework.stereotype.Component;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.human.entity.Human;

import java.util.ArrayList;

@Component
public class SeaStorage {
    ArrayList<Ship> ships = new ArrayList<Ship>();
    ArrayList<Human> humans = new ArrayList<Human>();
}
