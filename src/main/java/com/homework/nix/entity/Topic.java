package com.homework.nix.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "topics")
public class Topic extends AbstractEntity {

    @Column(nullable = false)
    private String topicName;

    @ManyToOne
    @JoinColumn(nullable = false, name = "lesson_id")
    private Lesson lesson;

    public Topic() { super(); }
}
