package test.labs;

import com.company.Division;
import com.company.Person;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestPersonMethods {
    /**
     * getAge method should return age person in years depending on his birthday
     */
    @Test
    public void testGetAge(){
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                 LocalDate.of(1999,4,27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2005, 12, 27), new BigDecimal(10000), new Division("Работник"));
        Person person3 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                LocalDate.of(2020, 12, 27), new BigDecimal(10000), new Division("Работник"));
        Assert.assertEquals(20, (int)person1.getAge());
        Assert.assertEquals(13, (int)person2.getAge());
    }
}
