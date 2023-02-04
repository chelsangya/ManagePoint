package com.managepoint.managepoint.pojo;

import com.managepoint.managepoint.entity.BroadCast;
import com.managepoint.managepoint.entity.Draft;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DraftPojo {
    private Integer id;
    @NotEmpty(message="Email cannot be empty")
    private String email;
    @NotEmpty(message="Topic cannot be empty")
    private String topic;
    @NotEmpty(message="Description cannot be empty")
    private String description;
    public DraftPojo(Draft draft) {
        this.id = draft.getId();
        this.email = draft.getEmail();
        this.topic = draft.getTopic();
        this.description = draft.getDescription();
    }
}
