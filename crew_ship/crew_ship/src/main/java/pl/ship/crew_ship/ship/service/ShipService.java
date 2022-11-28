package pl.ship.crew_ship.ship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.repository.ShipRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipService {
    private ShipRepository repository;

    @Autowired
    public ShipService(ShipRepository shipRepository){
        this.repository = shipRepository;
    }
    @Transactional
    public Ship saveShip(Ship ship){
        return repository.save(ship);
    }


    @Transactional
    public void deleteShip(Integer shipId){
        repository.deleteById(shipId);
    }



    public Optional<Ship> findShipById(Integer id){
        return repository.findById(id);
    }


}
