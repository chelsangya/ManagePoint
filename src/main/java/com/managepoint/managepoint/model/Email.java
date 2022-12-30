package com.managepoint.managepoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="email")
public class Email {
    @Id
    @SequenceGenerator(name = "email_id_seq_gen", sequenceName = "email_email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "email_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="e_id")
    private Integer e_Id;
    @Column(name="e_title")
    private String e_title;
    @Column(name = "e_content",nullable = false)
    private String e_content;
    @Column(name="e_status",nullable = false)
    private  String e_status;
    @ManyToOne
    @JoinColumn(name="ue_id",nullable=false)
    private User user;
}
