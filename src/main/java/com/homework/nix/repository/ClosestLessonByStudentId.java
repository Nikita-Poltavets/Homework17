package com.homework.nix.repository;

import com.homework.nix.entity.Lesson;
import com.homework.nix.entity.Student;
import com.homework.nix.entity.Topic;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestLessonByStudentId {

    private Session session;

    public ClosestLessonByStudentId(Session session){
        this.session = session;
    }

    public void findClosetLessonForStudentByStudentId(Long studentId){


                List<Lesson> lessons = session.load(Student.class, studentId)
                            .getGroup()
                            .getLessons()
                            .stream()
                            .filter(l -> l.getTimestamp().getEpochSecond() > Instant.now().getEpochSecond())
                            .collect(Collectors.toList());

                Lesson closetLesson = lessons
                            .stream()
                            .min(Comparator.comparing(Lesson::getTimestamp))
                            .get();

                Date myDate = Date.from(closetLesson.getTimestamp());


                SimpleDateFormat formatterForTime = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat formatterForDate = new SimpleDateFormat("dd.MM.yyyy");
                String formattedDate = formatterForDate.format(myDate);
                String formattedTime = formatterForTime.format(myDate);

                System.out.println("Closet lesson for student with id " + studentId + ":");
                System.out.println("Date - " + formattedDate);
                System.out.println("Time - " + formattedTime);
                System.out.println("Teacher - " + closetLesson.getTeacher().getFirstName() + " " + closetLesson.getTeacher().getLastName());
                for (Topic topic : closetLesson.getTopics()){
                    System.out.println("Topic - " + topic.getTopicName());
                }
    }
}
