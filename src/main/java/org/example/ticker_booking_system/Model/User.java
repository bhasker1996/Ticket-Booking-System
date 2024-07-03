package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "USER")
public class User extends BaseModel{

    private String name;
    private String email;
    @OneToMany
    private List<Ticket> tickets;
}
