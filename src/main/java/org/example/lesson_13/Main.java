package org.example.lesson_13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<Student>();
        students.add(new Student("Mike", 1, 1, 3));
        students.add(new Student("Alice", 1, 1, 4));
        students.add(new Student("Carl", 1, 1, 2));
        students.add(new Student("Carla", 2, 3, 5));

        Student.removeBadStudents(students);
        Student.enterNextYear(students);

        System.out.println("Студенты на курсе:");
        Student.printStudents(students, 1);

        TelefonBook phoneBook = new TelefonBook();
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "789-012");
        phoneBook.add("Петров", "345-678");
        phoneBook.add("Rylova", "+79058887798");
        phoneBook.add("Петров", "+79058887798");

        System.out.println(phoneBook.get("Петров"));
    }
}