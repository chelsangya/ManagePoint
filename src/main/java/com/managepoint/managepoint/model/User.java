package com.managepoint.managepoint.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "mp_user_seq_gen", sequenceName = "mp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="u_id")
    private Integer id;

    @Column(name="u_name",nullable = false)
    private String name;
    @Column(name = "u_phone",nullable = false,unique = true)
    private String phone;
    @Column(name = "u_email",nullable = false,unique = true)
    private String email;
    @Column(name = "u_address",nullable = false)
    private String address;
    @Column(name = "u_password",nullable = false)
    private String password;
    @Column(name = "u_image")
    private String image;
}
