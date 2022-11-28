package pl.ship.crew_ship.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.ship.crew_ship.dto.GetHumanResponse;
import pl.ship.crew_ship.dto.GetHumansResponse;
import pl.ship.crew_ship.dto.CreateHumanRequest;
import pl.ship.crew_ship.dto.UpdateHumanRequest;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.human.service.HumanService;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.service.ShipService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
@RequestMapping("api/ships/{shipId}/humans")
public class HumanShipController {
    private HumanService humanService;
    private ShipService shipService;
    @Autowired
    public HumanShipController(HumanService humanService, ShipService shipService){
        this.humanService = humanService;
        this.shipService = shipService;
    }
    @GetMapping
    public ResponseEntity<GetHumansResponse> getHumans(@PathVariable("shipId") Integer shipId){
        Optional<Ship> ship = shipService.findShipById(shipId);
        return ship.map(value -> ResponseEntity.ok(GetHumansResponse.entityToDtoMapper(
        ).apply(humanService.findAllByShip(value)))).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @GetMapping("{id}")
    public ResponseEntity<GetHumanResponse> getHumanById(@PathVariable("shipId") Integer shipId,
                                                         @PathVariable("id") Integer humanId){
        Optional<Ship> ship = shipService.findShipById(shipId);
        if(ship.isPresent()){
            Optional<Human> human = humanService.find(ship.get(), humanId);
            if(human.isPresent()){
                return ResponseEntity.ok(GetHumanResponse.entityToDtoMapper().apply(human.get()));
            }
            else{
                return ResponseEntity.notFound().build();
            }

        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Void> createHuman(@RequestBody CreateHumanRequest request, @PathVariable("shipId") Integer shipId,
                                            UriComponentsBuilder builder
                                            ){
        Optional<Ship> ship = shipService.findShipById(shipId);
        if(ship.isPresent()){

            //humanService.saveHuman();
            Human human = CreateHumanRequest.dtoToEntityMapper(ship.get()).apply(request);
            humanService.saveHuman(human);
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{humanId}")
    public ResponseEntity<Void> updateHuman(@RequestBody UpdateHumanRequest request, @PathVariable("shipId") Integer shipId, @PathVariable("humanId") Integer humanId){
        Optional<Ship> ship = shipService.findShipById(shipId);
        if(ship.isPresent()){
            Optional<Human> human = humanService.find(ship.get(), humanId);
            if(human.isPresent()){
                UpdateHumanRequest.dtoToEntityMapper(ship.get()).apply(human.get(),request);
                humanService.updateHuman(human.get());
                return ResponseEntity.accepted().build();
            }
            else{
                return ResponseEntity.notFound().build();
            }

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHuman(@PathVariable("shipId") Integer shipId,@PathVariable("id") Integer humanId){
        Optional<Ship> ship = shipService.findShipById(shipId);
        if(ship.isPresent()){
            Optional<Human> human = humanService.find(ship.get(), humanId);
            if(human.isPresent()){
                humanService.deleteHuman(human.get());
                return ResponseEntity.accepted().build();
            }
            else{
                return ResponseEntity.notFound().build();
            }

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


}
