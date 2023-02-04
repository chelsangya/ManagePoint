package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="email")
public class Email {
    @Id
    @SequenceGenerator(name = "email_id_seq_gen",
            sequenceName = "email_email_id_seq",
            allocationSize = 1)
    @GeneratedValue(generator = "email_id_seq_gen",
            strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name = "content",
            nullable = false)
    private String content;
    @Column(name="status",
            nullable = false)
    private  String status;
    @Column(name = "date",
            nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name="ue_id",
            nullable=false)
    private User user;
//    @ManyToMany
//    @JoinTable(name = "email_subscriber",
//            joinColumns = @JoinColumn(name = "e_id"),
//            inverseJoinColumns = @JoinColumn(name = "s_id"))
//    private Set<Subscriber> subscribers;
}
