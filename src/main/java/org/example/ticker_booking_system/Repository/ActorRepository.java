package org.example.ticker_booking_system.Repository;

import org.example.ticker_booking_system.Model.Actor;
import org.example.ticker_booking_system.Model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
