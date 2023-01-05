package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subscriber_Tag {
    @EmbeddedId
    Subscriber_Tag_Id subscriberTagId;

    @ManyToOne
    @MapsId("t_id")
    @JoinColumn(name="fk_t_id",nullable=false)
    private Tag tag;
    @ManyToOne
    @MapsId("s_id")
    @JoinColumn(name="fk_s_id",nullable=false)
    private Subscriber subscriber;
}
