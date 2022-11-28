package pl.ship.crew_ship.ship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.entity.event.ShipEventRepository;
import pl.ship.crew_ship.ship.repository.ShipRepository;

import java.util.EventListener;
import java.util.List;
import java.util.Optional;

@Service
public class ShipService {
    private ShipRepository repository;
    private ShipEventRepository eventRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository, ShipEventRepository eventRepository){
        this.repository = shipRepository;
        this.eventRepository = eventRepository;
    }
    @Transactional
    public Ship saveShip(Ship ship){
        Ship saved_ship = repository.save(ship);
        eventRepository.create(saved_ship);
        return saved_ship;
    }

    @Transactional
    public void updateShip(Ship ship){

        repository.save(ship);
    }
    @Transactional
    public void deleteShip(Integer shipId){

        repository.deleteById(shipId);
        eventRepository.delete(shipId);

    }


    public List<Ship> findAllShips(){
        return repository.findAll();
    }
    public Optional<Ship> findShipById(Integer id){
        return repository.findById(id);
    }


}
