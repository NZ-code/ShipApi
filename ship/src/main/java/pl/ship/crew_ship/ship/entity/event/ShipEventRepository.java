package pl.ship.crew_ship.ship.entity.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.entity.event.dto.CreateShipRequest;

@Repository
public class ShipEventRepository {
    private RestTemplate restTemplate;

    @Autowired
    public ShipEventRepository(@Value("${humans.url}") String baseUrl){
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }
    public void delete(Integer shipId){
        restTemplate.delete("/ships/{id}", shipId);
    }
    public void create(Ship ship){
        restTemplate.postForLocation("/ships", CreateShipRequest.entityToDtoMapper().apply(ship));
    }
}
