package org.example.ticker_booking_system.Service;

import org.example.ticker_booking_system.Constant.ShowSeatStatus;
import org.example.ticker_booking_system.Model.ShowSeat;
import org.example.ticker_booking_system.Model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {


        //Checking if the selected seats are available
        for(int showSeatId : showSeatIds)
        {
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new Exception("Seat not available");
            }
        }

        for(int showSeatId : showSeatIds)
        {
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }

        //write the logic for payment flow

        return new Ticket();
    }

    public String greet(){
        return "Hello World";
    }
}
