package com.homework.nix.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "marks")
public class Mark extends AbstractEntity{

    @Column(nullable = false)
    private Integer mark;

    @ManyToOne
    @JoinColumn(nullable = false, name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false, name = "exam_id")
    Exam exam;

    public Mark() {super();}
}
