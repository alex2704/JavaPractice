package com.soap;
import com.entity.Repo;
import com.entity.Person;
import services.all.*;

import java.util.ArrayList;
import java.util.List;

public class SoapService implements com.soap.SoapServiceSkeletonInterface {

    public GetPersonsByAgeResponseDocument getPersonsByAge(GetPersonsByAgeDocument getPersonsByAge) {
        int age = getPersonsByAge.getGetPersonsByAge().getAge();

        List<services.all.Person> persons = new ArrayList<>();
        Repo repo = new Repo();
        services.all.Repo list = services.all.Repo.Factory.newInstance();
        List<Person> personsList = repo.searchByAge(age);

        for(Person person:personsList)
        {
            services.all.Person personInst=services.all.Person.Factory.newInstance();
            personInst.setPersonId(person.getId());
            personInst.setAge(person.getAge());
            personInst.setName(person.getName());
            persons.add(personInst);
        }

        list.setPersonArray((services.all.Person[])persons.toArray());
        GetPersonsByAgeResponseDocument personsResponseDocument = GetPersonsByAgeResponseDocument.Factory.newInstance();
        GetPersonsByAgeResponseDocument.GetPersonsByAgeResponse personsResponse = GetPersonsByAgeResponseDocument.GetPersonsByAgeResponse.Factory.newInstance();
        personsResponse.setReturn(list);
        personsResponseDocument.setGetPersonsByAgeResponse(personsResponse);
        return personsResponseDocument;
    }

    public GetPersonResponseDocument getPerson(GetPersonDocument getPerson) {
        int id=getPerson.getGetPerson().getPersonId();

        Repo repo = new Repo();

        services.all.Person person1=services.all.Person.Factory.newInstance();
        Person person2 = repo.searchById(id);

        if(person2 == null)
            return null;

        person1.setAge(person2.getAge());
        person1.setName(person2.getName());

        GetPersonResponseDocument personResponseDocument = GetPersonResponseDocument.Factory.newInstance();
        GetPersonResponseDocument.GetPersonResponse personResponse = GetPersonResponseDocument.GetPersonResponse.Factory.newInstance();
        personResponse.setReturn(person1);
        personResponseDocument.setGetPersonResponse(personResponse);

        return personResponseDocument;
    }
}
