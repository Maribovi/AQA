package org.example;

public class Park {
    public static void main(String[] args) {
    }

    class Attraction {
        String attractionType;
        String workingHours;
        String price;

        Attraction(String attractionType, String workingHours, String price) {
            this.attractionType = attractionType;
            this.workingHours = workingHours;
            this.price = price;
        }
    }
}