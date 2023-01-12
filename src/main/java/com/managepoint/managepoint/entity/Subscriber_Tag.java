package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subscriber_Tag {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @MapsId("t_id")
    @JoinColumn(name="fk_t_id",nullable=false)
    private Tag tag;
    @ManyToOne
    @MapsId("s_id")
    @JoinColumn(name="fk_s_id",nullable=false)
    private Subscriber subscriber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
