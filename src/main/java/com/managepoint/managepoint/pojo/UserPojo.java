package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    @NotEmpty(message = "Name can't be empty")
    private String u_name;
    @NotEmpty(message = "Email can't be empty")
    private String u_email;
    @NotEmpty(message = "Phone can't be empty")
    private String u_phone;
    @NotEmpty(message = "Address can't be empty")
    private String u_address;
    @NotEmpty(message = "Password can't be empty")
    private String u_password;
    public UserPojo(User user){
        this.u_email= user.getU_email();
        this.u_name= user.getU_name();
        this.u_phone= user.getU_phone();
        this.u_password=user.getU_password();
        this.u_address = user.getU_address();
    }

}
