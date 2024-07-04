package org.example.ticker_booking_system.Repository;

import org.example.ticker_booking_system.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
