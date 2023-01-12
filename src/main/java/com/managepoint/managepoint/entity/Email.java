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
    @SequenceGenerator(name = "email_id_seq_gen", sequenceName = "email_email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "email_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="e_id")
    private Integer e_id;
    @Column(name="e_title")
    private String e_title;
    @Column(name = "e_content",nullable = false)
    private String e_content;
    @Column(name="e_status",nullable = false)
    private  String e_status;
    @Column(name = "e_date",nullable = false)
    private Date e_date;
    @ManyToOne
    @JoinColumn(name="ue_id",nullable=false)
    private User user;
    @ManyToMany
    @JoinTable(name = "email_subscriber", joinColumns = @JoinColumn(name = "e_id"), inverseJoinColumns = @JoinColumn(name = "s_id"))
    private Set<Subscriber> subscribers;
}
