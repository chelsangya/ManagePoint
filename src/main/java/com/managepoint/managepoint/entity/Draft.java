package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "draft")
public class Draft {
    @Id
    @SequenceGenerator(name = "draft_id_seq_gen",
            sequenceName = "draft_email_id_seq",
            allocationSize = 1)
    @GeneratedValue(generator = "draft_id_seq_gen",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "topic")
    private String topic;
    @Column(name = "description")
    private String description;

}
