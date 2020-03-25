package com.company;

import ru.vsu.lab.entities.enums.Gender;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        DataMas arr = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                java.time.LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                java.time.LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        arr.add(person1);
        arr.add(person2);
        arr.add(person3);
//        arr.add(person3);
//        arr.add(person2);
//        arr.add(person4);
//        arr.add(person5);
//
//        arr.sortBySurname();
////        DataMas result = arr.search("Вася", "Вупкин");
//        for (int i=0; i<arr.getLength(); i++){
//            System.out.println(arr.get(i).getAge());
//        }
    }
}
