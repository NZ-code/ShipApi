package pl.ship.crew_ship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.service.ShipService;
import pl.ship.crew_ship.human.service.HumanService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SeaInitializer {
    private HumanService humanService;

    @Autowired
    private ShipService shipService;
    SeaInitializer(HumanService humanService, ShipService shipService){
        this.humanService = humanService;
        this.shipService = shipService;
    }

    @PostConstruct
    public void init(){



        List<Ship> shipList = new ArrayList<>();
        var erebus = new Ship(1,"HMS Erebus",32.0, Collections.emptyList());

        var terror = new Ship(2,"HMS Terror",31.0, Collections.emptyList());


        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(1,"Sir John Franklin",59, erebus));
        humanList.add(new Human(2,"James Fitzjames",31,erebus));
        humanList.add(new Human(3,"Graham Gore",35,erebus));
        humanList.add(new Human(4,"Henry Thomas",31,erebus));
        humanList.add(new Human(5,"Francis Crozier",49,terror));
        humanList.add(new Human(6,"Edward Little",33,terror));
        humanList.add(new Human(7,"George Henry Hodgson",28,terror));
        humanList.add(new Human(8,"John Irving",30,terror));
        shipList.add(erebus);
        shipList.add(terror);
        for(var ship : shipList){
            shipService.saveShip(ship);
        }
        for(var human : humanList){
            humanService.saveHuman(human);
        }


    }
}
