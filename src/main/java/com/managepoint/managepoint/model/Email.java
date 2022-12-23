package com.managepoint.managepoint.model;

import jakarta.persistence.*;

@Entity
@Table(name="email")
public class Email {
    @Id
    @SequenceGenerator(name = "email_id_seq_gen", sequenceName = "email_email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "email_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="e_id")
    private Integer uId;
    @Column(name="e_title")
    private String title;
    @Column(name = "e_content",nullable = false)
    private String content;
    @Column(name="e_status",nullable = false)
    private  String status;
    @ManyToOne
    @JoinColumn(name="ue_id",nullable=false)
    private User user;
}
