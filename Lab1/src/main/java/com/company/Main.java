package com.company;

import org.joda.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        DataMas arr = new DataMas();
        Person person = new Person(5, "иван", "Пупкин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(3, "Саша", "Пупкин", "Васильевич", "м",
                new LocalDate(1999, 4, 27));
        Person person3 = new Person(2, "Вася", "Пупкин", "Васильевич", "м",
                new LocalDate(2007, 4, 27));
        arr.add(person);
        arr.add(person);
        arr.add(person);
        arr.add(person);
        arr.add(person3);
        arr.add(person2);

        System.out.println();
        for (int i=0; i<arr.getLength(); i++){
            arr.sortByBirthday();
            System.out.println(arr.get(i).getAge());
        }
    }
}
