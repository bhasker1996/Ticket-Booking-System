package org.example.ticker_booking_system.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ticker_booking_system.Constant.AuditoriumFeature;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<Show> shows;
    @OneToMany
    private List<Seat> seats;
    @ElementCollection
    @Enumerated(value = EnumType.STRING) //creates relationship between entity class and enum in DB.
    private List<AuditoriumFeature> auditoriumFeature;


}
