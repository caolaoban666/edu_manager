package com.ty.hh.edu.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String userName;
    private String role;
}
