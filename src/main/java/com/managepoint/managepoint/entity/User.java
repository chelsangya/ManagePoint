package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_mp_user_u_email", columnNames = "u_email")})
public class User implements UserDetails {
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
    @Column(name = "u_image",nullable = true)
    private String u_image;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.u_password;
    }

    @Override
    public String getUsername() {
        return this.u_email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
