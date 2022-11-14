package pl.ship.crew_ship.human.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.ship.entity.Ship;

import java.util.List;
import java.util.Optional;


@Repository
public interface HumanRepository extends JpaRepository<Human,Integer> {
    List<Human> findAllByShip(Ship ship);

    Optional<Human> findByIdAndShip(Integer id, Ship ship);
}
