package org.example.ticker_booking_system.Service;

import org.example.ticker_booking_system.Model.User;
import org.example.ticker_booking_system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email, String password) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null)
        {
            throw new Exception("User with same email exists");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }

    public User login(String email, String password) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser == null)
        {
            throw new Exception("Usre with email does not exist");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword()))
        {
            return savedUser;
        }
        throw new Exception("Invalid password");
    }
}