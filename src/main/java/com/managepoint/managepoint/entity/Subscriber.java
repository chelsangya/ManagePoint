package com.managepoint.managepoint.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="subscriber")
public class Subscriber {
    @Id
    @SequenceGenerator(name = "subscriber_id_seq_gen", sequenceName = "subscriber_subscriber_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "subscriber_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "s_id")
    private Integer s_id;
    @Column(name="s_name" ,nullable = false)
    private String s_name;
    @Column(name="s_email",nullable = false)
    private String s_email;
    @ManyToOne
    @JoinColumn ( name ="us_id", nullable = false )
    private User  user;
    @ManyToMany
    @JoinTable(name = "subscriber_tag", joinColumns = @JoinColumn(name = "s_id"), inverseJoinColumns = @JoinColumn(name = "t_id"))
    private Set<Tag> tags;

    @ManyToMany(mappedBy = "subscribers")
    private Set<Email> emails;
}
