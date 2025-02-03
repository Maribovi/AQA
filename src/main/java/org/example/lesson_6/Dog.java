package org.example.lesson_6;

public class Dog extends Animal {
    static int counterDogs = 0;

    public Dog(String name) {
        super(name);
        counterDogs++;
    }

    @Override
    void run(int length) {
        if (length < 500) {
            System.out.println(this.name + " " + "пробежал(а)" + " " + length + " " + "м.");
        } else {
            System.out.println("Превышена дистанция.");
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= 10) {
            System.out.println(this.name + " " + "проплыл(а)" + " " + distance + " " + "м.");
        } else {
            System.out.println("Превышена дистанция.");
        }
    }
}