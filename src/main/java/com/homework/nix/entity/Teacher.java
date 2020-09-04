package com.homework.nix.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher extends AbstractEntity{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "teacher")
    private List<Group> groups;

    @ManyToOne
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    public Teacher() { super(); }
}
