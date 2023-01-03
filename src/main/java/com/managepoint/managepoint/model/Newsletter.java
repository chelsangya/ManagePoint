package com.managepoint.managepoint.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @Column(name="n_title")
    private String n_title;
    @Column(name = "n_content",nullable = false)
    private String n_content;
    @Column(name="n_image")
    private String n_image;
    @ManyToOne
    @JoinColumn(name="ne_id",nullable=false)
    private User user;
}

