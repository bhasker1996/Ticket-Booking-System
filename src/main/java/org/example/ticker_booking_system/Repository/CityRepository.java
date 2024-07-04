package org.example.ticker_booking_system.Repository;

import org.example.ticker_booking_system.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findCityByName(String cityName);

}
