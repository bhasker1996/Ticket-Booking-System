package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.example.ticker_booking_system.Constant.SeatStatus;
import org.example.ticker_booking_system.Constant.SeatType;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    int row;
    int col;
    @Enumerated(value = EnumType.STRING)
    SeatType seatType;
    String seatNumber;
    @Enumerated(value = EnumType.STRING)
    SeatStatus status;

}
