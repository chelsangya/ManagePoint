package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @NotEmpty(message = "Email can't be empty")
    private String email;
    @NotEmpty(message = "Phone can't be empty")
    private String phone;
    @NotEmpty(message = "Address can't be empty")
    private String address;
    @NotEmpty(message = "Password can't be empty")
    private String password;
    private String OTP;
    public UserPojo(User user){
        this.id=user.getId();
        this.email= user.getEmail();
        this.name= user.getName();
        this.phone= user.getPhone();
        this.password=user.getPassword();
        this.address = user.getAddress();
        this.OTP = user.getOTP();
    }

}
