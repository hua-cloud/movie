package com.cust.movie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer uid;
    private String username;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
}
