package org.example.ticker_booking_system.Service;

import org.example.ticker_booking_system.Model.City;
import org.example.ticker_booking_system.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName)
    {
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    public City saveCity(City city)
    {
        return cityRepository.save(city);
    }

    public City getCityById(int cityId)
    {
        return cityRepository.findById(cityId).get();
    }

    public boolean deleteCity(int cityId)
    {
        cityRepository.deleteById(cityId);
        return true;
    }

    public City getCityByName(String cityName) {
      return cityRepository.findCityByName(cityName);
    }

    public List<City> getAllCities() {
        List<City> all = cityRepository.findAll();
        return all;
    }
}
