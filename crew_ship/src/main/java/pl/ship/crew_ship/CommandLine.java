package pl.ship.crew_ship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.ship.crew_ship.ship.entity.Ship;
import pl.ship.crew_ship.ship.service.ShipService;
import pl.ship.crew_ship.human.entity.Human;
import pl.ship.crew_ship.human.service.HumanService;

import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    private HumanService humanService;
    private ShipService shipService;
    @Autowired
    public CommandLine(HumanService humanService, ShipService shipService){
        this.humanService = humanService;
        this.shipService = shipService;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char cmd = ' ';
        while (cmd != 'q'){
            System.out.println("Enter command[s - ships, h - humans, q - quit]");
            cmd = scanner.next().toLowerCase().charAt(0);
            if(cmd == 'q'){
                break;
            }
            else if(cmd == 's'){
                System.out.println("Enter command{Ships}[g - get all, d - delete, a - add, f - find]");
                cmd = scanner.next().toLowerCase().charAt(0);
                Integer id;
                switch (cmd){
                    case 'g':
                        var ships = shipService.findAllShips();
                        for(var ship : ships){
                            System.out.println(ship);
                        }

                        break;
                    case 'a':
                        System.out.println("Write index:");
                        id = scanner.nextInt();
                        System.out.println("Write ship name:");
                        String name = scanner.next();
                        System.out.println("Write ship legnth:");
                        Double length = scanner.nextDouble();
                        shipService.saveShip(new Ship(id,name,length, Collections.emptyList()));
                        break;
                    case 'f':
                        System.out.println("Write index:");
                        id = scanner.nextInt();
                        System.out.println(shipService.findShipById(id));
                        break;
                    case 'd':
                        System.out.println("Write index:");
                        id = scanner.nextInt();
                        Optional<Ship> ship = shipService.findShipById(id);
                        shipService.deleteShip(ship.get().getId());
                        break;
                }
            }
            else if(cmd == 'h') {
                System.out.println("Enter command{Humans}[g - get all, d - delete, a - add, f - find]");
                cmd = scanner.next().toLowerCase().charAt(0);
                Integer id;
                switch (cmd) {
                    case 'g':
                        var humans = humanService.findAllHumans();
                        for (var human : humans) {
                            System.out.println(human);
                        }

                        break;
                    case 'a':
                        System.out.println("Write index:");
                        id = scanner.nextInt();
                        System.out.println("Write human name:");
                        String name = scanner.next();
                        System.out.println("Write age:");
                        Integer age = scanner.nextInt();
                        var ships = shipService.findAllShips();
                        for (var ship : ships) {
                            System.out.println(ship);
                        }

                        System.out.println("Pick ship id:");
                        var shipId = scanner.nextInt();
                        var ship = shipService.findShipById(shipId).get();
                        humanService.saveHuman(new Human(id, name, age, ship));
                        break;
                    case 'f':
                        System.out.println("Write index:");
                        id = scanner.nextInt();
                        //System.out.println(humanService.findHumanById(id));
                        break;
                    case 'd':
                        System.out.println("Write index:");
                        //id = scanner.nextInt();
                        //Human human = humanService.findB(id);
                        //humanService.deleteHuman(human);
                        break;
                }
            }
            else {
                    System.out.println("Wrong command:");
            }


    }
}
}
