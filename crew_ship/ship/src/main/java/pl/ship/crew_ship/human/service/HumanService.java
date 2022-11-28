package pl.ship.crew_ship.human.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.human.repository.HumanRepository;
import pl.ship.crew_ship.ship.entity.Ship;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class HumanService {
    private HumanRepository repository;

    public HumanService(HumanRepository humanRepository){
        repository = humanRepository;
    }
    @Transactional
    public Human saveHuman(Human human){
    return repository.save(human);
    }
    public void updateHuman(Human human){
        repository.save(human);
    }
    @Transactional
    public void deleteHuman(Human human){
        repository.delete(human);
    }
    public List<Human> findAllHumans(){
        return repository.findAll();
    }
    public Optional<Human> find(Integer id) {

        return repository.findById(id);
    }
    public Optional<Human> find(Ship ship, Integer id){
        return repository.findByIdAndShip(id,ship);
    }
    public List<Human> findAllByShip(Ship ship){
        return repository.findAllByShip(ship);
    }
}
