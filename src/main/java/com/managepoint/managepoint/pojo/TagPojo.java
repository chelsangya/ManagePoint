package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagPojo {

    private Integer t_id;
    private String t_name;

    public TagPojo(Tag tag){
        this.t_id= tag.getT_id();
        this.t_name= tag.getT_name();
    }
}