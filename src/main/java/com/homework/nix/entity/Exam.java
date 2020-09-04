package com.homework.nix.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "examResult")
public class Exam extends AbstractEntity {

    @OneToMany(mappedBy = "exam")
    private List<Mark> marks;

    public Exam() { super(); }
}
