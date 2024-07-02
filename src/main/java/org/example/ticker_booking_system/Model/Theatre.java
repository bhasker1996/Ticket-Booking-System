package org.example.ticker_booking_system.Model;

import jakarta.persistence.OneToMany;

import java.util.*;
public class Theatre extends BaseModel
{
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> Auditorium;

}
