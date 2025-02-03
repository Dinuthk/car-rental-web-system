package com.example.Car.Rental.service.auth;

import com.example.Car.Rental.dto.SignupRequest;
import com.example.Car.Rental.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);
}
