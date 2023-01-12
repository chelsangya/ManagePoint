package com.managepoint.managepoint.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="tag")
public class Tag {
    @Id
    @SequenceGenerator(name = "tag_id_seq_gen", sequenceName = "tag_tag_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "tag_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "t_id")
    private Integer t_id;
    @Column(name="t_name",nullable = false)
    private String t_name;

    @ManyToMany(mappedBy = "tags")
    private Set<Subscriber> subscribers;

}
