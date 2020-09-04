package com.homework.nix.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends AbstractEntity{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    @ManyToOne
    @JoinColumn(nullable = false, name = "group_id")
    Group group;

    public Student() { super(); }
}
