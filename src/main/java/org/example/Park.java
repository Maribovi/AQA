package org.example;

public class Park {
    String name;

    Park(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Park funPark = new Park("Парк развлечений");
        Park.Attraction merryGoRound = funPark.new Attraction("Карусель",
                "9:00 - 18:00", "500 рублей");
        Park.Attraction bumperCars = funPark.new Attraction("Автодром",
                "9:00 - 18:00", "600 рублей");
        System.out.println(funPark.getName() + "\n" + "\n" + merryGoRound);
        System.out.println();
        System.out.println(bumperCars);
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

        public String toString() {
            return "Название аттракциона: " + attractionType + "\n"
                    + "Время работы: " + workingHours + "\n"
                    + "Стоимость: " + price;
        }
    }
}
