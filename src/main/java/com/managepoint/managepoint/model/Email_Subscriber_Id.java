package com.managepoint.managepoint.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Embeddable
public class Email_Subscriber_Id implements Serializable {
    @Column(name="s_id")
    private Integer s_id;
    @Column(name="e_id")
    private Integer e_id;
}
