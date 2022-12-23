package com.managepoint.managepoint.model;
import jakarta.persistence.*;

@Entity
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
    @JoinColumn ( name ="ts_id", nullable = false )
    private Tag tag;
    @ManyToOne
    @JoinColumn ( name ="us_id", nullable = false )
    private User  user;
}
