package org.example.lesson_6;

import static org.example.lesson_6.Animal.catArray;
import static org.example.lesson_6.Animal.counterAnimals;
import static org.example.lesson_6.Cat.counterCats;
import static org.example.lesson_6.Cat.fillInCatFoodToBowl;
import static org.example.lesson_6.Dog.counterDogs;

public class Main {
    public static void main(String[] args) {
        catArray[0] = new Cat("Мурзик");
        catArray[1] = new Cat("Пушистик");
        catArray[2] = new Cat("Мурка");
        catArray[3] = new Cat("Фокс");

        Dog bobik = new Dog("Бобик");

        bobik.run(400);
        bobik.swim(5);
        catArray[0].run(100);
        catArray[0].swim(50);

        System.out.println("Количество созданных животных: " + counterAnimals + " шт.");
        System.out.println("Всего собак: " + counterDogs + " шт.");
        System.out.println("Всего кошек: " + counterCats + " шт.");

        fillInCatFoodToBowl(100);
        catArray[0].eat(10);
        catArray[1].eat(30);
        catArray[2].eat(50);
        catArray[1].eat(30);
        catArray[0].satiety();
        catArray[1].satiety();
        catArray[2].satiety();
        catArray[3].satiety();

        Triangle triangle1 = new Triangle("зеленый", "красный", 3, 4, 5);
        Rectangle rectangle1 = new Rectangle("синий", "бордовый", 7, 9);
        Circle circle1 = new Circle("желтый", "черный", 3);

        System.out.println(triangle1);
        System.out.println(rectangle1);
        System.out.println(circle1);
    }
}