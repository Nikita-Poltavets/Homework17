package com.homework.nix.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course extends AbstractEntity{

    @Column(nullable = false)
    private Integer courseNumber;

    @OneToMany(mappedBy = "course")
    private List<Group> groups;

    @OneToMany(mappedBy = "course")
    private List<Teacher> teachers;

    public Course(){ super(); }


}
