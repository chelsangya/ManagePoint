package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.Newsletter;
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
public class NewsletterPojo {
    private Integer id;
    @NotEmpty(message="Title cannot be empty")
    private String title;
    @NotEmpty(message="Content cannot be empty")
    private String content;


    public NewsletterPojo(Newsletter newsletter){
        this.id=newsletter.getId();
        this.title= newsletter.getTitle();
        this.content= newsletter.getContent();
    }
}
