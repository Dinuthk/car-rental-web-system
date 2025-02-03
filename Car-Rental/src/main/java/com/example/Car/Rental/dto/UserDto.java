package com.example.Car.Rental.dto;

import com.example.Car.Rental.enums.UserRole;
import lombok.Data;


@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private UserRole userRole;

}
