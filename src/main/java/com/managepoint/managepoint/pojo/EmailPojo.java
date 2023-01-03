package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.model.Email;
import com.managepoint.managepoint.model.Tag;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailPojo {
    @NotEmpty(message="ID cannot be empty")
    private Integer e_id;
    @NotEmpty(message="Title cannot be empty")
    private String e_title;
    @NotEmpty(message="Status cannot be empty")
    private String e_status;
    @NotEmpty(message="Content cannot be empty")
    private String e_content;

    public EmailPojo(Email email){
        this.e_id= email.getE_id();
        this.e_title= email.getE_title();
        this.e_content=email.getE_content();
        this.e_status=email.getE_status();
    }
}