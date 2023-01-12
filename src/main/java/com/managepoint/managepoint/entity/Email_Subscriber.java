package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Email_Subscriber {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
