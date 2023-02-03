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
@Table(name="users",
        uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_mp_user_email",
                columnNames = "email")
})
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "mp_user_seq_gen",
            sequenceName = "mp_user_id_seq",
            allocationSize = 1)
    @GeneratedValue(generator = "mp_user_seq_gen",
            strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="name",
            nullable = false)
    private String name;
    @Column(name = "phone",
            nullable = false,
            unique = true)
    private String phone;
    @Column(name = "email",
            nullable = false,
            unique = true)
    private String email;
    @Column(name = "address",
            nullable = false)
    private String address;
    @Column(name = "password",
            nullable = false)
    private String password;
    @Column(name = "image",
            nullable = true,
            columnDefinition = "varchar(255) default '/static/images/logo.png'")
    private String image;

    @Transient
    private String imageBase64;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

//    @Override
//    public String getPassword() {
//        return this.password;
//    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
