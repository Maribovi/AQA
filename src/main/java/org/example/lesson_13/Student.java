package org.example.lesson_13;

import java.util.Set;

public class Student {
    private String name;
    private int group;
    private int course;
    private int grades;

    public Student(String name, int group, int course, int grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getGrades() {
        return grades;
    }

    public int getCourse() {
        return course;
    }

    public static void removeBadStudents(Set<Student> students) {
        students.removeIf(student -> student.getGrades() < 3);
    }

    public static void enterNextYear(Set<Student> students) {
        for (Student student : students) {
            if (student.getGrades() >= 3) {
                student.promote();
            }
        }
    }

    public void promote() {
        this.course++;
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}