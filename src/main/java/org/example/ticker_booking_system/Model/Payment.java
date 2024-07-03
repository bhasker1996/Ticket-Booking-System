package org.example.ticker_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.ticker_booking_system.Constant.PaymentMode;
import org.example.ticker_booking_system.Constant.PaymentStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;

}

/*
        payment     Ticket
            1           1
            M           1

 */
