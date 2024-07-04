package org.example.ticker_booking_system.Controller;

import org.example.ticker_booking_system.DTO.CityRequestDTO;
import org.example.ticker_booking_system.Model.City;
import org.example.ticker_booking_system.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName)
    {
        City city = cityService.getCityByName(cityName);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/city")
    public ResponseEntity getAllCities()
    {
        List<City> allCities = cityService.getAllCities();
        return ResponseEntity.ok(allCities);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO)
    {
        try {
            String cityName = cityRequestDTO.getName();
            if(cityName==null || cityName.length()==0 || cityName.isBlank())
            {
                throw new Exception("City Name is invalid");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId)
    {
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }

}
