package org.example.ticker_booking_system.Service;

import org.example.ticker_booking_system.Model.ShowSeat;
import org.example.ticker_booking_system.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId)
    {
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat seat){
        return showSeatRepository.save(seat);
    }

}
