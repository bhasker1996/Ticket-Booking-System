package org.example.ticker_booking_system.Controller;

import org.example.ticker_booking_system.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/hello")
    public ResponseEntity greet()
    {
        String res = ticketService.greet();
        return ResponseEntity.ok(res);
    }

}
