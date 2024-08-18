package web.Service;

import web.Models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars;

    public List<Car> getAllCars() {
        return cars;
    }
    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("Honda", "Civic", 2019));
        cars.add(new Car("Ford", "Focus", 2018));
        cars.add(new Car("Chevrolet", "Malibu", 2017));
        cars.add(new Car("Nissan", "Altima", 2021));
    }

    public List<Car> getCars(Integer count) {
        if (count == null || count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
