package com.managepoint.managepoint.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String image;
}
