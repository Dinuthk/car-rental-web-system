package com.example.Car.Rental.controller;

import com.example.Car.Rental.dto.SignupRequest;
import com.example.Car.Rental.dto.UserDto;
import com.example.Car.Rental.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpCustomer(@RequestBody SignupRequest signupRequest){
        if (authService.hasCustomerWithEmail(signupRequest.getEmail())){
            return new ResponseEntity<>("Customer already exist with this email",HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        UserDto createdCustomerDto = authService.createCustomer(signupRequest);
        if (createdCustomerDto == null) return new ResponseEntity<>(
                "Customer not created, Come again letter", HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(createdCustomerDto,HttpStatus.CREATED);
    }
}
