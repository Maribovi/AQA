package org.example.lesson_6;

public class CatBowl {
 private int foodAmount;

    public int getFoodAmount() {
        return this.foodAmount;
    }

    public void fillInCatFoodToBowl(int addFood) {
        this.foodAmount += addFood;
    }
}