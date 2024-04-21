package com.inn.pfeEst.controllers;

import com.inn.pfeEst.dtos.SignupRequest;
import com.inn.pfeEst.dtos.UserDto;
import com.inn.pfeEst.services.auth.AuthoSrv;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthoController {


    private final AuthoSrv authoSrv;
    public AuthoController( AuthoSrv authoSrv){
        this.authoSrv=authoSrv;
    }

    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        UserDto createUserDto= authoSrv.createUser(signupRequest);
        if(createUserDto== null){
            return new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
    }
}
