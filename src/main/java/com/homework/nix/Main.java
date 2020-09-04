package com.homework.nix;

import com.homework.nix.repository.BestGroupByTeacherId;
import com.homework.nix.repository.ClosestLessonByStudentId;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {


        var cfg = new Configuration().configure();

        try(var sessionFactory = cfg.buildSessionFactory();
            var session = sessionFactory.openSession()
        ) {
            try {
                ClosestLessonByStudentId closestLessonByStudentId = new ClosestLessonByStudentId(session);
                closestLessonByStudentId.findClosetLessonForStudentByStudentId((long)1);

                System.out.println("\n");
                BestGroupByTeacherId bestGroupByTeacherId = new BestGroupByTeacherId(session);
                bestGroupByTeacherId.findBestGroupByTeacherId((long)1);

            } catch (Exception ignored) {}


        }
    }
}
