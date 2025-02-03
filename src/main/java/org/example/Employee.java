package org.example;

public class Employee {
    String name;
    String familyName;
    String fathersName;
    String position;
    String email;
    String phone;
    long salary;
    int age;

    Employee(String name, String familyName, String fathersName,
             String position, String email, String phone, long salary, int age) {
        this.name = name;
        this.familyName = familyName;
        this.fathersName = fathersName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void display() {
        System.out.println("Фамилия: " + familyName + "\n" + "Имя: " + name + "\n" +
                "Отчество: " + fathersName + "\n" + "Должность: " + position + "\n" +
                "Эл. почта: " + email + "\n" + "Телефон: " + phone + "\n" +
                "Зарплата: " + salary + " руб." + "\n" + "Возраст: " + age + "\n");
    }

    static Employee[] empArray = new Employee[5];

    public static void main(String[] args) {
        empArray[0] = new Employee("Владимир", "Савельев", "Сергеевич", "инженер",
                "example@mail.ru", "89991234567", 40000, 50);
        empArray[1] = new Employee("Светлана", "Савельева", "Владимировна", "директор",
                "example@gmail.ru", "89001234567", 60000, 45);
        empArray[2] = new Employee("Сергей", "Иванов", "Иванович", "секретарь",
                "example@yandex.ru", "89009876543", 35000, 20);
        empArray[3] = new Employee("Иван", "Прокуров", "Владиславович", "программист",
                "example@yahoo.ru", "89112345567", 60000, 60);
        empArray[4] = new Employee("Валентина", "Федорова", "Моисеевна", "тестировщик",
                "example2@mail.ru", "89001112233", 40000, 30);
    }
}