package com.managepoint.managepoint.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class Subscriber_Tag_Id implements Serializable {
    @Column(name="s_id")
    private Integer s_id;
    @Column(name="t_id")
    private Integer t_id;
}
