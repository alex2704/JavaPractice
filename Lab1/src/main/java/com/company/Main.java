package com.company;

import org.joda.time.LocalDate;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataMas arr = new DataMas();
        Person person = new Person(5, "иван", "Аыупкин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(3, "Саша", "Аупкина", "Васильевич", "м",
                new LocalDate(1999, 4, 27));
        Person person3 = new Person(2, "Вася", "Вупкин", "Васильевич", "м",
                new LocalDate(2007, 4, 27));
        arr.add(person);
        arr.add(person);
        arr.add(person);
        arr.add(person);
        arr.add(person3);
        arr.add(person2);

        arr.sortBySurname();
        ArrayList<Person> result = arr.search(5);
        System.out.println(result.get(0).getSurname());
        System.out.println("Завершен");
        for (int i=0; i<arr.getLength(); i++){
            System.out.println(arr.get(i).getSurname());
        }
    }
}
