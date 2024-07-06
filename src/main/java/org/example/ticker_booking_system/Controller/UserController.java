package org.example.ticker_booking_system.Controller;

import org.example.ticker_booking_system.DTO.UserLoginRequestDTO;
import org.example.ticker_booking_system.DTO.UserSignUpRequestDTO;
import org.example.ticker_booking_system.Model.User;
import org.example.ticker_booking_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO requestDTO) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
                userService.signUp(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPassword()
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO requestDTO) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
            userService.login(requestDTO.getEmail(), requestDTO.getPassword())
        );
    }

}
