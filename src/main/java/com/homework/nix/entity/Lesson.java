package com.homework.nix.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson extends AbstractEntity {

    @ManyToOne
    @JoinColumn(nullable = false, name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(nullable = false, name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "lesson")
    private List<Topic> topics;

    @Column(nullable = false)
    private Instant timestamp;

    public Lesson() { super(); }
}
