package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Show extends BaseModel{

    int row;
    int col;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    private List<ShowSeat> showSeats;

}

/*
        show        Auditorium
           1            1
           M            1

           Since show -> which movie, in which theatre, in which audi, with what features etc...

 */
