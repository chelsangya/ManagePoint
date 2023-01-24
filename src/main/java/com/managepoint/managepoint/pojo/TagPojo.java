package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.Tag;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TagPojo {
    @NotEmpty(message="ID cannot be empty")
    private Integer id;
    @NotEmpty(message="Name cannot be empty")
    private String name;

    public TagPojo(Tag tag){
        this.id= tag.getId();
        this.name= tag.getName();
    }
}