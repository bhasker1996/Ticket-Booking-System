package org.example.ticker_booking_system.Model;

import jakarta.persistence.OneToMany;

import java.util.List;

public class City extends BaseModel{

    private String name;
    @OneToMany
    private List<Theatre> theatres;

}
