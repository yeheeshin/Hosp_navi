package com.Hosp.navi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String position;

    private String hospital_name;
}
