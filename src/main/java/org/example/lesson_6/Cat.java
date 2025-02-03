package org.example.lesson_6;

public class Cat extends Animal {
    static int counterCats = 0;
    static int food = 0;
    boolean isHungry = true;

    public Cat(String name) {
        super(name);
        counterCats++;
    }

    @Override
    void run(int length) {
        if (length <= 200) {
            System.out.println(this.name + " " + "пробежал(а)" + " " + length + " " + "м.");
        } else {
            System.out.println("Превышена дистанция.");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int fillInCatFoodToBowl(int addFood) {
        food += addFood;
        return food;
    }

    public int eat(int catMeal) {
        if ((food - catMeal) < 0) {
            return food;
        } else {
            this.isHungry = false;
            return food -= catMeal;
        }
    }

    void satiety() {
        if (isHungry) {
            System.out.println(name + " голодный(ая). Покорми.");
        } else {
            System.out.println("Не верь, " + name + " ел(а).");
        }
    }
}