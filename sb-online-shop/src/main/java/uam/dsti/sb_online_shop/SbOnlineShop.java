package uam.dsti.sb_online_shop;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uam.dsti.sb_online_shop.domain.Car;
import uam.dsti.sb_online_shop.domain.CarOwner;
import uam.dsti.sb_online_shop.domain.CarOwnerRepository;
import uam.dsti.sb_online_shop.domain.CarRepository;

@SpringBootApplication
public class SbOnlineShop implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SbOnlineShop.class);

    @Autowired
    private CarRepository repository;
    
    @Autowired
    private CarOwnerRepository orepository;

    public static void main(String[] args) {
        SpringApplication.run(SbOnlineShop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CarOwner owner1 = new CarOwner("Ousmane", "KA");
        CarOwner owner2 = new CarOwner("Albert Sandokh", "Bakhoum");
        CarOwner owner3 = new CarOwner("Souleymane", "Diallo");

        // Save all owners to the database
        orepository.saveAll(Arrays.asList(owner1, owner2, owner3));


		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, BigDecimal.valueOf(59000), owner1);
        Car car2 = new Car("Nissan", "Leaf", "White", "SS3-3002", 2019, BigDecimal.valueOf(29000), owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, BigDecimal.valueOf(39000), owner3);

        // Save all cars to the database
        repository.saveAll(Arrays.asList(car1, car2, car3));

        // Fetch and log the cars
        for (Car car : repository.findAll()) {
            logger.info("Car: " + car.getBrand() + " " + car.getModel());
        }
    }
}
