package org.example.lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TelefonBook {
    private HashMap<String, ArrayList<String>> phoneBook;
    private HashSet<String> uniqueNumbers;

    public TelefonBook() {
        phoneBook = new HashMap<>();
        uniqueNumbers = new HashSet<>();
    }

    public boolean add(String surname, String phoneNumber) {
        if (uniqueNumbers.contains(phoneNumber)) {
            System.out.println("\n" + "Номер телефона " + phoneNumber + " принадлежит другому пользователю.");
            return false;
        }
        phoneBook.putIfAbsent(surname, new ArrayList<String>());
        phoneBook.get(surname).add(phoneNumber);
        uniqueNumbers.add(phoneNumber);
        return true;
    }

    public ArrayList<String> get(String surname) {
        System.out.println("\n" + "Телефон " + surname);
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }
}