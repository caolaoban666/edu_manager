package com.ty.hh.edu.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class StudentRequest {
    @NotBlank(message = "姓名不能为空")
    private String name;

    private String gender;

    @NotBlank(message = "出生日期不能为空")
    private LocalDate birthday;

    private String email;
}
