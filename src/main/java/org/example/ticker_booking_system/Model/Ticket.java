package org.example.ticker_booking_system.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ticker_booking_system.Constant.TicketStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    private LocalDateTime timeOfBooking;
    private double totalAmount;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;

    @Enumerated(value = EnumType.STRING)
    private TicketStatus ticketStatus;

}
