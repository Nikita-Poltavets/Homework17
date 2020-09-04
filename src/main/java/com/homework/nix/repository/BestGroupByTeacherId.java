package com.homework.nix.repository;

import com.homework.nix.entity.Group;
import com.homework.nix.entity.Mark;
import com.homework.nix.entity.Student;
import com.homework.nix.entity.Teacher;
import org.hibernate.Session;

import java.util.*;
import java.util.stream.Collectors;

public class BestGroupByTeacherId {

    private Session session;

    public BestGroupByTeacherId (Session session){
        this.session = session;
    }

    public void findBestGroupByTeacherId(Long teacherId) {

        List<Group> groups = session.load(Teacher.class, teacherId)
                .getGroups();


        List<List<Student>> listList = groups.stream().map(Group::getStudents).collect(Collectors.toList());

        Map<Group, Double> integers = new HashMap<>();


        for (int i = 0; i < listList.size(); i++) {
            integers.put(listList.get(i).stream().map(Student::getGroup).findFirst().get() ,listList.get(i)
                    .stream()
                    .map(Student::getMarks)
                    .flatMap(Collection::stream)
                    .mapToLong(Mark::getMark)
                    .average().getAsDouble());
        }

        Map<Group, Double> groupDoubleMap = sortMapByValueForSymbol(integers);

        Group bestGroup = groupDoubleMap.entrySet().stream().findFirst().get().getKey();


        System.out.println("Average mark on the exam of all groups:");
        for (Map.Entry<Group, Double> entry : integers.entrySet()) {
            System.out.println(entry.getKey().getGroupNumber() + " : " + entry.getValue());
        }

        System.out.println("The best group - " + bestGroup.getGroupNumber() + ". Course of the best group - " + bestGroup.getCourse().getCourseNumber());

        System.out.println("Students of the best group:");
        for (Student student : bestGroup.getStudents()){
            System.out.println(student.getFirstName() + " " + student.getLastName() + " with mark - " + student.getMarks().stream().findFirst().get().getMark());
        }
    }

    public static Map<Group, Double> sortMapByValueForSymbol(final Map<Group, Double> groupDoubleMap) {

        return groupDoubleMap.entrySet()

                .stream()

                .sorted((Map.Entry.<Group, Double>comparingByValue().reversed()))

                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}


