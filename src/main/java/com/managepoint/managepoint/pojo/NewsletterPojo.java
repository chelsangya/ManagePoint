package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.model.Newsletter;
import com.managepoint.managepoint.model.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsletterPojo {
    @NotEmpty(message="ID cannot be empty")
    private Integer n_id;
    @NotEmpty(message="Title cannot be empty")
    private String n_title;
    @NotEmpty(message="Content cannot be empty")
    private String n_content;
    @NotEmpty(message="Image cannot be empty")
    private String n_image;
    public NewsletterPojo(Newsletter newsletter){
        this.n_id=newsletter.getN_id();
        this.n_title= newsletter.getN_title();
        this.n_content= newsletter.getN_content();
        this.n_image=newsletter.getN_image();
    }
}
