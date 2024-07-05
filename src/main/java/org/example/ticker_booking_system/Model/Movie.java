package org.example.ticker_booking_system.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ticker_booking_system.Constant.MovieFeature;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;
    @ManyToMany
    private List<Actor> actors;
    private String description;
    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<MovieFeature> movieFeatures;

//    public Movie() {
//    }

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
