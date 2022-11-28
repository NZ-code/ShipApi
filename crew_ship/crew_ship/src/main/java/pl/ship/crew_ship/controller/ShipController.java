package pl.ship.crew_ship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.ship.crew_ship.dto.CreateShipRequest;

import pl.ship.crew_ship.human.service.HumanService;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.service.ShipService;

import java.util.Optional;

@RestController
@RequestMapping("/api/ships")
public class ShipController {
    private HumanService humanService;
    private ShipService shipService;
    @Autowired
    public ShipController(HumanService humanService, ShipService shipService){
        this.humanService = humanService;
        this.shipService = shipService;
    }


    // TODO : Post override existed value
    @PostMapping
    public ResponseEntity<Void> createShip(@RequestBody CreateShipRequest request,UriComponentsBuilder builder){
        Ship ship = CreateShipRequest.dtoToEntityMapper(id-> shipService.findShipById(id).orElseThrow()).apply(request);
       // ship =
        shipService.saveShip(ship);
        return ResponseEntity.created(builder.pathSegment("api","ships","{id}")
                .buildAndExpand(ship.getId()).toUri()).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteShip(@PathVariable("id") Integer id){
        Optional<Ship> ship = shipService.findShipById(id);
        if(ship.isPresent()){
            for(var human : ship.get().getCrew()){
                humanService.deleteHuman(human);
            }
            shipService.deleteShip(ship.get().getId());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
