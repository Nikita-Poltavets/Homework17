package com.homework.nix;

import com.homework.nix.entity.*;
import org.hibernate.cfg.Configuration;

import java.time.Instant;

public class MockDataLoader {
    public static void main(String[] args) {
        var cfg = new Configuration().configure();

        try(var sessionFactory = cfg.buildSessionFactory();
            var session = sessionFactory.openSession()
        ) {
            try {
                session.beginTransaction();

                Course course = new Course();
                course.setCourseNumber(3);



                Teacher teacher = new Teacher();
                teacher.setCourse(course);
                teacher.setFirstName("Grigory");
                teacher.setLastName("Pechorin");



                Group group = new Group();
                group.setCourse(course);
                group.setGroupNumber("PZPI-17-9");
                group.setTeacher(teacher);

                Group group2 = new Group();
                group2.setCourse(course);
                group2.setGroupNumber("PZPI-17-10");
                group2.setTeacher(teacher);



                Student student = new Student();
                student.setFirstName("Boris");
                student.setLastName("Ulianov");
                student.setGroup(group);

                Student student1 = new Student();
                student1.setFirstName("Yana");
                student1.setLastName("Prigojin");
                student1.setGroup(group);

                Student student2 = new Student();
                student2.setFirstName("Yuriy");
                student2.setLastName("Kotik");
                student2.setGroup(group2);

                Student student3 = new Student();
                student3.setFirstName("Pavel");
                student3.setLastName("Karma");
                student3.setGroup(group2);

                Student student4 = new Student();
                student4.setFirstName("Jesus");
                student4.setLastName("Christ");
                student4.setGroup(group2);



                Instant instant = Instant.parse("2020-09-13T19:00:28.666Z" );
                Instant instant2 = Instant.parse("2020-09-15T19:00:28.666Z" );
                Instant instant3 = Instant.parse("2020-09-17T19:00:28.666Z" );

                Lesson lesson = new Lesson();
                lesson.setTimestamp(instant);
                lesson.setGroup(group);
                lesson.setTeacher(teacher);

                Lesson lesson2 = new Lesson();
                lesson2.setTimestamp(instant2);
                lesson2.setGroup(group);
                lesson2.setTeacher(teacher);

                Lesson lesson3 = new Lesson();
                lesson3.setTimestamp(instant3);
                lesson3.setGroup(group);
                lesson3.setTeacher(teacher);



                Topic topic = new Topic();
                topic.setLesson(lesson);
                topic.setTopicName("Hibernate");

                Topic topic2 = new Topic();
                topic2.setLesson(lesson2);
                topic2.setTopicName("JDBC");

                Topic topic3 = new Topic();
                topic3.setLesson(lesson3);
                topic3.setTopicName("Spring");



                Exam exam = new Exam();



                Mark mark = new Mark();
                mark.setMark(90);
                mark.setExam(exam);
                mark.setStudent(student);

                Mark mark1 = new Mark();
                mark1.setMark(95);
                mark1.setExam(exam);
                mark1.setStudent(student1);

                Mark mark2 = new Mark();
                mark2.setMark(90);
                mark2.setExam(exam);
                mark2.setStudent(student2);

                Mark mark3 = new Mark();
                mark3.setMark(80);
                mark3.setExam(exam);
                mark3.setStudent(student3);

                Mark mark4 = new Mark();
                mark4.setMark(90);
                mark4.setExam(exam);
                mark4.setStudent(student4);



                session.save(course);
                session.save(teacher);
                session.save(group);
                session.save(group2);
                session.save(student);
                session.save(student1);
                session.save(student2);
                session.save(student3);
                session.save(student4);
                session.save(lesson);
                session.save(lesson2);
                session.save(lesson3);
                session.save(topic);
                session.save(topic2);
                session.save(topic3);
                session.save(exam);
                session.save(mark);
                session.save(mark1);
                session.save(mark2);
                session.save(mark3);
                session.save(mark4);

                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }

        }
    }
}
