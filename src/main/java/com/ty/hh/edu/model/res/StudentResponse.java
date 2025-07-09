package com.ty.hh.edu.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String fullName;
    private String gender;
    private String phone;
    private String email;
    private Integer age;
    private LocalDateTime createdAt;
}

