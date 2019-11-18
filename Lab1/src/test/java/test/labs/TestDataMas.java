package test.labs;

import com.company.DataMas;
import com.company.Division;
import com.company.Person;
import enums.Gender;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestDataMas {

    /**
     * the add method should add person object in datamas
     */
    @Test
    public void testAdd(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
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
    public void testDelete(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
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
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortById();
        Assert.assertEquals(1, (int)dataMas.get(0).getId());
        Assert.assertEquals(2, (int)dataMas.get(1).getId());
        Assert.assertEquals(3, (int)dataMas.get(2).getId());
    }

    /**
     * the sortById method should sort items ascending by birthday
     */
    @Test
    public void testSortByBirthday() throws Exception{
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortById();
        Assert.assertEquals(15, (int)dataMas.get(0).getAge());
        Assert.assertEquals(17, (int)dataMas.get(1).getAge());
        Assert.assertEquals(18, (int)dataMas.get(2).getAge());
    }

    /**
     * the sortBySurname method should sort items ascending by surname
     */
    @Test
    public void testSortBySurname(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Арыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Хышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortBySurname();
        Assert.assertEquals("Арыткин", dataMas.get(0).getLastName());
        Assert.assertEquals("Кеник", dataMas.get(1).getLastName());
        Assert.assertEquals("Хышев", dataMas.get(2).getLastName());
    }

    /**
     * the searchMethod by id should returns objects with a given id
     */
    @Test
    public void testSearchId(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        try {
            Person result = dataMas.search(2);
            Assert.assertEquals(person2, result);
        }
        catch (Exception ex){
            Assert.assertEquals("Объекта с соответсвующим id не найдено", ex.getMessage());
        }
    }

    /**
     * the searchMethod by id should returns objects with a given Name and Surname
     */
    @Test
    public void testSearchNameSurname(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                new LocalDate(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                new LocalDate(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        try {
            DataMas result = dataMas.search("Иван", "Арыткин");
            Assert.assertEquals(person2, result.get(0));
            Assert.assertEquals(person1, result.get(1));
        }
        catch (Exception ex){
            Assert.assertEquals("Объекта с соответсвующими параметрами не найдено", ex.getMessage());
        }
    }
}
