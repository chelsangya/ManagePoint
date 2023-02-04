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
    @SequenceGenerator(name = "subscriber_id_seq_gen",
            sequenceName = "subscriber_subscriber_id_seq",
            allocationSize = 1)
    @GeneratedValue(generator = "subscriber_id_seq_gen",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name="name" ,
            nullable = false)
    private String name;
    @Column(name="email",
            nullable = false)
    private String email;

}
