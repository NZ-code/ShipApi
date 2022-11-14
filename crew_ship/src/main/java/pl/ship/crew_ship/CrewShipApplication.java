package pl.ship.crew_ship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrewShipApplication {

	public static void main(String[] args) {

		var beans = SpringApplication.run(CrewShipApplication.class, args);
		for(var beansName : beans.getBeanDefinitionNames()){
			System.out.println(beansName);
		}
	}

}
