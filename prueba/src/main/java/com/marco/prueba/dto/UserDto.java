package com.marco.prueba.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate born_date;
    private String phone_number;
    private Long role_id;
}
