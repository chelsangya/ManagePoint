package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.BroadCast;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BroadCastPojo {
    private Integer id;
    @NotEmpty(message="Email cannot be empty")
    private String email;
    @NotEmpty(message="Topic cannot be empty")
    private String topic;
    @NotEmpty(message="Description cannot be empty")
    private String description;
    public BroadCastPojo(BroadCast broadCast) {
        this.id = broadCast.getId();
        this.email = broadCast.getEmail();
        this.topic = broadCast.getTopic();
        this.description = broadCast.getDescription();
    }
}
