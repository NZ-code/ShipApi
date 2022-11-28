package pl.ship.crew_ship.ship.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ship.crew_ship.ship.entity.Ship;


@Repository
public interface ShipRepository extends JpaRepository<Ship,Integer> {

}
