package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="newsletter")
public class Newsletter {
    @Id
    @SequenceGenerator(name = "newsletter_id_seq_gen", sequenceName = "newsletter_email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "newsletter_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="n_id")
    private Integer n_id;
    @Column(name = "n_author",nullable = false)
    private Date e_author;
    @Column(name="n_title")
    private String n_title;
    @Column(name = "n_content",nullable = false)
    private String n_content;
    @Column(name = "n_date",nullable = false)
    private Date n_date;
    @Column(name="n_image")
    private String n_image;
    @ManyToOne
    @JoinColumn(name="ne_id",nullable=false)
    private User user;
}

