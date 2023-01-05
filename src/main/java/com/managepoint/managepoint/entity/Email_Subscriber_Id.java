package com.managepoint.managepoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
public class Email_Subscriber_Id implements Serializable {
    @Column(name="s_id")
    private Integer s_id;
    @Column(name="e_id")
    private Integer e_id;
}








