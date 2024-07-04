package org.example.ticker_booking_system.DTO;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showseatIds;
    private Integer UserId;
}
