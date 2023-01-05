package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Email_Subscriber {
    @EmbeddedId
    Email_Subscriber_Id emailSubscriberId;

    @ManyToOne
    @MapsId("e_id")
    @JoinColumn(name="fk_e_id",nullable=false)
    private Email email;
    @ManyToOne
    @MapsId("s_id")
    @JoinColumn(name="fk_s_id",nullable=false)
    private Subscriber subscriber;
   @Column(name="es_date",nullable = false)
    private Date es_date;
}
