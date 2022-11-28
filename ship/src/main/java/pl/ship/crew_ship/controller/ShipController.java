package pl.ship.crew_ship.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.ship.crew_ship.dto.CreateShipRequest;
import pl.ship.crew_ship.dto.GetShipResponse;
import pl.ship.crew_ship.dto.GetShipsResponse;
import pl.ship.crew_ship.dto.UpdateShipRequest;

import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.service.ShipService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ships")
public class ShipController {
    //private HumanService humanService;
    private ShipService shipService;
    @Autowired
    //public ShipController(HumanService humanService, ShipService shipService){
    public ShipController(ShipService shipService){
        //this.humanService = humanService;
        this.shipService = shipService;
    }
    @GetMapping
    public ResponseEntity<GetShipsResponse> getShips(){

        return ResponseEntity.ok(GetShipsResponse.entityToDtoMapper().apply(shipService.findAllShips()));
    }
    @GetMapping("{id}")
    public ResponseEntity<GetShipResponse> getShipById (@PathVariable("id")Integer id){
        Optional<Ship> ship = shipService.findShipById(id);
        return ship.map( value->ResponseEntity.ok(GetShipResponse.entityToDtoMapper().apply(value))).orElseGet(
                ()->ResponseEntity.notFound().build()
        );
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
    @PutMapping("{id}")
    public ResponseEntity<Void> updateShip(@RequestBody UpdateShipRequest request, @PathVariable("id") Integer id){
        Optional<Ship> ship = shipService.findShipById(id);
        if(ship.isPresent()){
            UpdateShipRequest.dtoToEntityUpdater().apply(ship.get(),request);
            shipService.updateShip(ship.get());

            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteShip(@PathVariable("id") Integer id){
        Optional<Ship> ship = shipService.findShipById(id);
        if(ship.isPresent()){
//            for(var human : ship.get().getCrew()){
//                humanService.deleteHuman(human);
//            }
            shipService.deleteShip(ship.get().getId());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
