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
    @Column(name="id")
    private Integer id;
    @Column(name = "author",nullable = false)
    private Date author;
    @Column(name="title")
    private String title;
    @Column(name = "content",nullable = false)
    private String content;
    @Column(name = "date",nullable = false)
    private Date date;
    @Column(name="image")
    private String image;
    @Transient
    private String thumbnailBase64;
    @ManyToOne
    @JoinColumn(name="ne_id",nullable=false)
    private User user;
}

