package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Actor extends  BaseModel{
    private String name;
}
