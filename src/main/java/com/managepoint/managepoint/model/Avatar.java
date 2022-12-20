package com.managepoint.managepoint.model;

import jakarta.persistence.*;

@Entity
@Table(name="avatar")
public class Avatar {
    @Id
    @SequenceGenerator(name = "mp_user_seq_gen", sequenceName = "mp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer aID;
    @Column(nullable = false)
    private String aImage;

}
