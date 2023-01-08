package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.Subscriber;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberPojo {
    @NotEmpty(message="ID cannot be empty")
    private Integer s_id;
    @NotEmpty(message="Name cannot be empty")
    private String s_name;
    @Email
    private String s_email;
    public SubscriberPojo(Subscriber subscriber){
        this.s_id=subscriber.getS_id();
        this.s_name=subscriber.getS_name();
        this.s_email=subscriber.getS_email();
    }
}
