package test.labs;

import StreamApi.StreamApi;
import com.company.Division;
import com.company.Person;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestStreamApi {
    @Test
    public void testStreamApi(){
        StreamApi si = new StreamApi();
        List<IPerson> listPerson = new ArrayList<>();
        Person person1 = new Person(1, "Иван", "Прааткин", Gender.MALE,
                LocalDate.of(2001, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(2, "Саша", "Кеник", Gender.MALE,
                LocalDate.of(2001, 4, 22), new BigDecimal(15000), new Division("Работник"));
        Person person3 = new Person(3, "Вася", "Мышев", Gender.MALE,
                LocalDate.of(2001, 3, 21), new BigDecimal(40000), new Division("Работник"));
        Person person4 = new Person(4, "Вася", "Аганин", Gender.MALE,
                LocalDate.of(1970, 3, 21), new BigDecimal(4000), new Division("Работник"));
        listPerson.add(person1);
        listPerson.add(person2);
        listPerson.add(person3);
        listPerson.add(person4);
        //проверка метода getMapDivisionSalary
        si.getMapDivisionSalary(listPerson).forEach((key, value) -> {
            Assert.assertEquals("Работник", key);
            Assert.assertEquals(new BigDecimal(69000), value);
        });
        //проверка метода getMapSortbySurnameAndSalary5000
        Assert.assertEquals(person4, si.getMapSortbySurnameAndSalary5000(listPerson).get(4));
        //проверка метода getMapContractAA
        Assert.assertEquals(person1, si.getMapContractAA(listPerson).get(1));;
        // Проверка метода getMapCountPersonByYear
        Assert.assertEquals(new Long(3), si.getMapCountPersonByYear(listPerson).get(2001));
        Assert.assertEquals(new Long(1), si.getMapCountPersonByYear(listPerson).get(1970));
    }
}
