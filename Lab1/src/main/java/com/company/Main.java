package com.company;

import org.joda.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        DataMas arr = new DataMas();
        Person person = new Person(1, "иван", "Пупкин", "Васильевич", "м",
                new LocalDate(1999, 4, 27));
        Person person2 = new Person(2, "Саша", "Пупкин", "Васильевич", "м",
                new LocalDate(1999, 4, 27));
        Person person3 = new Person(3, "Вася", "Пупкин", "Васильевич", "м",
                new LocalDate(1999, 4, 27));
        arr.Add(person);
        arr.Add(person);
        arr.Add(person);
        arr.Add(person);
        arr.Add(person3);
        arr.Add(person2);
        arr.Delete(3);

        System.out.println(arr.Get(3).getName());
    }
}
