package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel
{
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> Auditorium;
    public Theatre(){}

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
