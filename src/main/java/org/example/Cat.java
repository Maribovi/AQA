package org.example.lesson_6;

public class Cat extends Animal {
    public static int counterCats = 0;
    public boolean isHungry = true;

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

    public int eat(int catMeal, CatBowl bowl) {
        int foodAmountInBowl = bowl.getFoodAmount();
        if ((foodAmountInBowl - catMeal) < 0) {
            System.out.println("В миске мало еды.");
            return foodAmountInBowl;
        } else {
            this.isHungry = false;
            bowl.fillInCatFoodToBowl(-catMeal);
            return foodAmountInBowl - catMeal;
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