package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailPojo {
    @NotNull(message="ID cannot be empty")
    private Integer id;
    @NotEmpty(message="Title cannot be empty")
    private String title;
    @NotEmpty(message="Status cannot be empty")
    private String status;
    @NotEmpty(message="Content cannot be empty")
    private String content;

    public EmailPojo(Email email){
        this.id= email.getId();
        this.title= email.getTitle();
        this.content=email.getContent();
        this.status=email.getStatus();
    }
}