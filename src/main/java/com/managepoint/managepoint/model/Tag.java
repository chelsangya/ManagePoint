package com.managepoint.managepoint.model;

import jakarta.persistence.*;

@Entity
@Table(name="tag")
public class Tag {
    @Id
    @SequenceGenerator(name = "tag_id_seq_gen", sequenceName = "tag_tag_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "tag_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "t_id")
    private Integer t_id;
    @Column(name="t_name",nullable = false)
    private String t_name;


}
