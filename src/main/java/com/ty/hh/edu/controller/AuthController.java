package com.ty.hh.edu.controller;

import com.ty.hh.edu.common.Result;
import com.ty.hh.edu.model.res.AuthResponse;
import com.ty.hh.edu.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ty.hh.edu.model.req.RegisterRequest;
import com.ty.hh.edu.model.req.LoginRequest;
import com.ty.hh.edu.utils.JwtUtil;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public Result<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return Result.success(authService.register(request));
    }

    @PostMapping("/login")
    public Result<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return Result.success(authService.login(request));
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        String token = JwtUtil.getTokenFromRequest(request);
        authService.logout(token);
        return Result.success("登出成功");
    }


}




