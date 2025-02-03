package com.example.Car.Rental.service.auth;

import com.example.Car.Rental.dto.SignupRequest;
import com.example.Car.Rental.dto.UserDto;
import com.example.Car.Rental.entity.User;
import com.example.Car.Rental.enums.UserRole;
import com.example.Car.Rental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //constructor created
public class AuthServiceImpl implements AuthService{


    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {

        User user = new User();

        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserRole(UserRole.CUSTOMER);
        User createUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(createUser.getId()); //id ek auto genarate wela tyenne
        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
