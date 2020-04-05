package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repo {

    private List<Person> persons;

    public Repo() {
        persons = new ArrayList<>();
        persons.add(new Person(1, 27, "Пётр"));
        persons.add(new Person(2, 28, "Иван"));
        persons.add(new Person(3, 34, "Артем"));
        persons.add(new Person(4, 12, "Александр"));
        persons.add(new Person(5, 55, "Антон"));
    }

    public Person searchById(int id){
        List<Person> personsFilter= this.persons.stream().filter(person->person.getId()==id)
                .collect(Collectors.toList());

        return personsFilter != null ? personsFilter.get(0) : null;
    }

    public List<Person> searchByAge(int age){
        List<Person> personsFilter= this.persons.stream().filter(person->person.getAge()==age)
                .collect(Collectors.toList());
        return personsFilter;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
