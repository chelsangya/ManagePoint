package com.managepoint.managepoint.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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
    private LocalDateTime es_date;
}
