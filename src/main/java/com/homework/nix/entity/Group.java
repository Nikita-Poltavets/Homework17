package com.homework.nix.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends AbstractEntity{

    @NaturalId
    @Column(nullable = false)
    private String groupNumber;

    @OneToMany(mappedBy = "group")
    private List<Lesson> lessons;

    @ManyToOne
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(nullable = false, name = "teacher_id")
    Teacher teacher;

    public Group(){ super(); }
}
