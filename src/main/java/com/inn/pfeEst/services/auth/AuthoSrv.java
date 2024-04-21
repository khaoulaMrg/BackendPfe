package com.inn.pfeEst.services.auth;

import com.inn.pfeEst.dtos.SignupRequest;
import com.inn.pfeEst.dtos.UserDto;

public interface AuthoSrv {
    UserDto createUser(SignupRequest signupRequest);
}
