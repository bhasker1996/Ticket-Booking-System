package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.ticker_booking_system.Constant.ShowSeatStatus;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    private int price;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value = EnumType.STRING)
    private ShowSeatStatus showSeatStatus;

    public ShowSeat() {
    }

    public ShowSeat(int price, Show show, Seat seat, ShowSeatStatus showSeatStatus) {
        this.price = price;
        this.show = show;
        this.seat = seat;
        this.showSeatStatus = showSeatStatus;
    }
}