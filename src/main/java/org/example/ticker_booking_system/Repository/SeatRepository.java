package org.example.ticker_booking_system.Repository;

import org.example.ticker_booking_system.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    Seat findSeatBySeatNumber(String seatNumber);
}
