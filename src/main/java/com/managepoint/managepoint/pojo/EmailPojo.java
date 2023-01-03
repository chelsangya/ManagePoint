package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.model.Email;
import com.managepoint.managepoint.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailPojo {
    private Integer e_id;
    private String e_title;
    private String e_status;
    private String e_content;

    public EmailPojo(Email email){
        this.e_id= email.getE_id();
        this.e_title= email.getE_title();
        this.e_content=email.getE_content();
        this.e_status=email.getE_status();
    }
}