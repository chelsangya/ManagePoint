package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TagPojo {
    @NotEmpty(message="ID cannot be empty")
    private Integer t_id;
    @NotEmpty(message="Name cannot be empty")
    private String t_name;

    public TagPojo(Tag tag){
        this.t_id= tag.getT_id();
        this.t_name= tag.getT_name();
    }
}