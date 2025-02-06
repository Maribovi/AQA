package org.example.lesson_6;

public abstract class Animal {
    public String name;
    public static int counterAnimals = 0;

    public Animal(String name) {
        this.name = name;
        counterAnimals++;
    }

    public static Cat[] catArray = new Cat[4];

    void run(int length) {
        System.out.println(this.name + " " + "пробежал(а)" + " " + length + " " + "м.");
    }

    void swim(int distance) {
        System.out.println(this.name + " " + "проплыл(а)" + " " + distance + " " + "м.");
    }
}