package test.labs;

import com.company.DataMas;
import com.company.Person;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;

public class TestDataMas {

    /**
     * the add method should add person object in datamas
     */
    @Test
    public void testAdd() throws Exception{
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Саша", "Кеник", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Мышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person1);
        dataMas.add(person2);
        dataMas.add(person3);
        Assert.assertEquals(person1, dataMas.get(0));
        Assert.assertEquals(person2, dataMas.get(1));
        Assert.assertEquals(person3, dataMas.get(2));
        Assert.assertEquals(3, dataMas.getLength());
    }

    /**
     * the delete method should delete person object from datamas
     */
    @Test
    public void testDelete() throws Exception{
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Саша", "Кеник", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Мышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person1);
        dataMas.add(person2);
        dataMas.add(person3);
        dataMas.delete(2);
        dataMas.delete(1);
        Assert.assertNull(dataMas.get(1));
        Assert.assertEquals(person1, dataMas.get(0));
    }

    /**
     * the sortById method should sort items ascending by id
     */
    @Test
    public void testSortById(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Саша", "Кеник", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Мышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortById();
        Assert.assertEquals(1, dataMas.get(0).getId());
        Assert.assertEquals(2, dataMas.get(1).getId());
        Assert.assertEquals(3, dataMas.get(2).getId());
    }

    /**
     * the sortById method should sort items ascending by birthday
     */
    @Test
    public void testSortByBirthday(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Саша", "Кеник", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Мышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortById();
        Assert.assertEquals(15, dataMas.get(0).getAge());
        Assert.assertEquals(17, dataMas.get(1).getAge());
        Assert.assertEquals(18, dataMas.get(2).getAge());
    }

    /**
     * the sortBySurname method should sort items ascending by surname
     */
    @Test
    public void testSortBySurname(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Арыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Саша", "Кеник", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Хышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortBySurname();
        Assert.assertEquals("Арыткин", dataMas.get(0).getSurname());
        Assert.assertEquals("Кеник", dataMas.get(1).getSurname());
        Assert.assertEquals("Хышев", dataMas.get(2).getSurname());
    }

    /**
     * the searchMethod by id should returns objects with a given id
     */
    @Test
    public void testSearchId(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Арыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Саша", "Кеник", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Хышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        Person result = dataMas.search(2);
        Assert.assertEquals(person2, result);
    }

    /**
     * the searchMethod by id should returns objects with a given Name and Surname
     */
    @Test
    public void testSearchNameSurname(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Арыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(2, "Иван", "Арыткин", "Юрьевич", "м",
                new LocalDate(2002, 4, 22));
        Person person3 = new Person(3, "Вася", "Хышев", "Иванович", "м",
                new LocalDate(2001, 3, 21));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        DataMas result = dataMas.search("Иван", "Арыткин");
        Assert.assertEquals(person2, result.get(0));
        Assert.assertEquals(person1, result.get(1));
    }
}
