package com.managepoint.managepoint.model;

import jakarta.persistence.*;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @SequenceGenerator(name = "mp_user_seq_gen", sequenceName = "mp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String name;

}
