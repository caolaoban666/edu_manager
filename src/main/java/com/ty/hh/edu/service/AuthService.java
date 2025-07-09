package com.ty.hh.edu.service;

import com.ty.hh.edu.model.req.LoginRequest;
import com.ty.hh.edu.model.req.RegisterRequest;
import com.ty.hh.edu.model.res.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    void logout(String token);
}
