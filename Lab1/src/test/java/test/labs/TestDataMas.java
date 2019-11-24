package test.labs;

import com.company.DataMas;
import com.company.Division;
import com.company.Person;
import Comparators.BirthDateComparator;
import Comparators.IdComparator;
import entities.IPerson;
import entities.enums.Gender;
import org.junit.Assert;
import org.junit.Test;
import repository.IRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Predicate;

public class TestDataMas {

    /**
     * the add method should add person object in datamas
     */
    @Test
    public void testAdd(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person1);
        dataMas.add(person2);
        dataMas.add(person3);
        Assert.assertEquals(person1, dataMas.get(0));
        Assert.assertEquals(person2, dataMas.get(1));
        Assert.assertEquals(person3, dataMas.get(2));
        Assert.assertNull(dataMas.get(3));
    }

    @Test
    public void testAddByIndex(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person1);
        dataMas.add(person2);
        dataMas.add(person3);
        dataMas.add(1, person3);
        dataMas.add(1, person2);
        dataMas.add(person1);
        Assert.assertEquals(person1, dataMas.get(0));
        Assert.assertEquals(person2, dataMas.get(1));
        Assert.assertEquals(person3, dataMas.get(2));
        Assert.assertEquals(person2, dataMas.get(3));
        Assert.assertEquals(person3, dataMas.get(4));
        Assert.assertEquals(person1, dataMas.get(5));
    }


    /**
     * the set method should change person object in datamas
     */
    @Test
    public void testSet(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person1);
        dataMas.add(person2);
        dataMas.add(person3);
        dataMas.set(0, person3);
        dataMas.set(1, person3);
        Assert.assertEquals(person3, dataMas.get(0));
        Assert.assertEquals(person3, dataMas.get(1));
        Assert.assertEquals(person3, dataMas.get(2));
    }

    /**
     * the delete method should delete person object from datamas
     */
    @Test
    public void testDelete(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person1);
        dataMas.add(person2);
        dataMas.add(person3);
        dataMas.delete(2);
        dataMas.delete(1);
        Assert.assertNull(dataMas.get(1));
        Assert.assertEquals(person1, dataMas.get(0));
    }

    /**
     * the testBubbleSortBy method should sort items ascending by comparator by bubble sort
     */
    @Test
    public void testBubbleSortBy(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.bubbleSortBy(new IdComparator());
        Assert.assertEquals(1, (int)dataMas.get(0).getId());
        Assert.assertEquals(2, (int)dataMas.get(1).getId());
        Assert.assertEquals(3, (int)dataMas.get(2).getId());
    }

    /**
     * the testSortSimpleInsertionBy method should sort items ascending by comparator by insertion sort
     */
    @Test
    public void testSortSimpleInsertionBy(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortBy(new BirthDateComparator());
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
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Хышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        dataMas.sortBySurname();
        Assert.assertEquals("Арыткин", dataMas.get(0).getLastName());
        Assert.assertEquals("Кеник", dataMas.get(1).getLastName());
        Assert.assertEquals("Хышев", dataMas.get(2).getLastName());
    }

    /**
     * the searchMethod by id should returns objects with a given condition
     */
    @Test
    public void searchById() {
        IRepository arr = new DataMas();
        Person person1 = new Person(1, "Иван", "Арыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Хышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        arr.add(person1);
        arr.add(person2);
        arr.add(person3);

        final Predicate<IPerson> isId = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson o) {
                return 3 == o.getId();
            }
        };
        DataMas res = (DataMas) arr.searchBy(isId);
        Assert.assertEquals(person3, res.get(0));
    }

    /**
     * the same method with different conditions
     */
    @Test
    public void testSearchNameSurname(){
        DataMas dataMas = new DataMas();
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2002, 4, 22), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(10000), new Division("Работник"));
        dataMas.add(person3);
        dataMas.add(person2);
        dataMas.add(person1);
        final Predicate<IPerson> isName = new Predicate<IPerson>() {
            @Override
            public boolean test(IPerson o) {
                return "Вася".equals(o.getFirstName()) && "Мышев".equals(o.getLastName());
            }
        };
        DataMas result = (DataMas) dataMas.searchBy(isName);
        Assert.assertEquals(person3, result.get(0));
    }

}
