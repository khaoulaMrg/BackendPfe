package com.inn.pfeEst.services.auth;

import com.inn.pfeEst.dtos.SignupRequest;
import com.inn.pfeEst.dtos.UserDto;
import com.inn.pfeEst.entity.User;
import com.inn.pfeEst.repositories.UserRepo;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthSrvImp implements  AuthoSrv {

    private final UserRepo userRepo;






    public AuthSrvImp( UserRepo userRepo) {
        this.userRepo = userRepo;

    }


    @Override
    public UserDto createUser(SignupRequest signupRequest){

        User user = new User();
        user.setName(SignupRequest.getName());
        user.setEmail(SignupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(SignupRequest.getPassword()));
        user.getUserRole ();
        User createUser = userRepo.save(user);
        UserDto createUserDto = new UserDto();
        createUserDto.setId(createUser.getId());
        createUserDto.setName(createUser.getName());
        createUserDto.setEmail(createUser.getEmail());
        createUserDto.setUserRole(createUser.getUserRole());
        return createUserDto;

    }

}
