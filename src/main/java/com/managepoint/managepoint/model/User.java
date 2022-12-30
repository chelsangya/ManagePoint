package com.managepoint.managepoint.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "mp_user_seq_gen", sequenceName = "mp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="u_id")
    private Integer u_id;

    @Column(name="u_name",nullable = false)
    private String u_name;
    @Column(name = "u_phone",nullable = false,unique = true)
    private String u_phone;
    @Column(name = "u_email",nullable = false,unique = true)
    private String u_email;
    @Column(name = "u_address",nullable = false)
    private String u_address;
    @Column(name = "u_password",nullable = false)
    private String u_password;
    @Column(name = "u_image")
    private String u_image;
}
