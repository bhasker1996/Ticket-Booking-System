package org.example.ticker_booking_system.Service;

import org.example.ticker_booking_system.Constant.AuditoriumFeature;
import org.example.ticker_booking_system.Constant.SeatStatus;
import org.example.ticker_booking_system.Constant.SeatType;
import org.example.ticker_booking_system.Constant.ShowSeatStatus;
import org.example.ticker_booking_system.Model.*;
import org.example.ticker_booking_system.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {

    private CityRepository cityRepository;
    private TheatreRepository theatreRepository;
    private AuditoriumRepository auditoriumRepository;
    private ShowRepository showRepository;
    private SeatRepository seatRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;

    @Autowired
    public InitService(CityRepository cityRepository, TheatreRepository theatreRepository, AuditoriumRepository auditoriumRepository, ShowRepository showRepository, SeatRepository seatRepository, MovieRepository movieRepository, UserRepository userRepository,
                       ShowSeatRepository showSeatRepository) {
        this.cityRepository = cityRepository;
        this.theatreRepository = theatreRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public boolean initialize()
    {
        City delhi = new City("Delhi");
        City bangalore = new City("Bangalore");
        City canberra = new City("Canberra");

        cityRepository.save(delhi);
        cityRepository.save(bangalore);
        cityRepository.save(canberra);

        City savedDelhi = cityRepository.findCityByName("Delhi");
        Theatre ashishTheatre = new Theatre("Ashish Multiplex","CP Delhi");
        Theatre nithinTheatre = new Theatre("Nithin IMAX","Selectcity, delhi");

        theatreRepository.save(ashishTheatre);
        theatreRepository.save(nithinTheatre);

        Theatre savedAshishTheatre = theatreRepository.findTheatreByName("Ashish Multiplex");
        Theatre savedNithinTheatre = theatreRepository.findTheatreByName("Nithin IMAX");

        List<Theatre> delhiTheatres = new ArrayList<>();
        delhiTheatres.add(ashishTheatre);
        delhiTheatres.add(nithinTheatre);
        savedDelhi.setTheatres(delhiTheatres);
        cityRepository.save(savedDelhi);

        for(int i=1; i <=5; i++)
        {
            Seat s = new Seat(i, i, SeatType.GOLD,i+" "+i,  SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }

        List<Seat> savedSeats = seatRepository.findAll();

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeature(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.IMAX));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);

        Auditorium savedAudi = auditoriumRepository.findAuditoriumByName("Audi01");
        Theatre savedTheatre = theatreRepository.findTheatreByName("Ashish Multiplex");
        List<Auditorium> auditoriums = new ArrayList<>();

        auditoriums.add(savedAudi);
        savedTheatre.setAuditorium(auditoriums);
        theatreRepository.save(savedTheatre);

        Movie movie = new Movie("Titanic", "best movie ever");
        movieRepository.save(movie);

        Show show = new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Titanic") );
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));
        showRepository.save(show);

        for(int i=1;i<=5; i++)
        {
            ShowSeat s = new ShowSeat(1251, showRepository.findById(1).get(), seatRepository.findSeatBySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }
        return true;
    }

}
