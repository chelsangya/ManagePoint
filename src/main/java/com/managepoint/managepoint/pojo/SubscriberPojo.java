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
    private Integer id;
    @NotEmpty(message="Name cannot be empty")
    private String name;
    @Email
    private String email;
    public SubscriberPojo(Subscriber subscriber){
        this.id=subscriber.getId();
        this.name=subscriber.getName();
        this.email=subscriber.getEmail();
    }
}
