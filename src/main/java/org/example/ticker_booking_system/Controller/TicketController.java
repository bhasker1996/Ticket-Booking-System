package org.example.ticker_booking_system.Controller;

import org.example.ticker_booking_system.DTO.BookTicketRequestDTO;
import org.example.ticker_booking_system.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        //validate BookTicketRequestDTO whether attributes are null or not , if null then throw some exception.

        return ResponseEntity.ok( ticketService.
                bookTicket(bookTicketRequestDTO.getShowseatIds()
                        , bookTicketRequestDTO.getUserId()));
    }

    @GetMapping("/hello")
    public ResponseEntity greet()
    {
        String res = ticketService.greet();
        return ResponseEntity.ok(res);
    }

}
