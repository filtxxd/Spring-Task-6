package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Models.Car;
import web.Service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        // Если count не передан, вернуть все машины
        if (count == null || count >= carService.getAllCars().size()) {
            count = carService.getAllCars().size();
        }

        List<Car> cars = carService.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
