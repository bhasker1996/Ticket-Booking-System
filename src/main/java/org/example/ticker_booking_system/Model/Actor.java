package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Actor extends  BaseModel{
    private String name;
    @ManyToMany
    private List<Movie> movies;
}
