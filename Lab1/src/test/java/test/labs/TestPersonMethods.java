package test.labs;

import com.company.Division;
import com.company.Person;
import enums.Gender;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TestPersonMethods {
    /**
     * getAge method should return age person in years depending on his birthday
     */
    @Test
    public void testGetAge(){
        Person person1 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2004, 4, 27), new BigDecimal(10000), new Division("Работник"));
        Person person2 = new Person(1, "Иван", "Прыткин", Gender.MALE,
                new LocalDate(2020, 12, 27), new BigDecimal(10000), new Division("Работник"));
        try{
        Assert.assertEquals(15, (int)person1.getAge());
        Assert.assertEquals(14, (int)person2.getAge());
        }
        catch (Exception ex){
            Assert.assertEquals("Введенная дата из будущего", ex.getMessage());
        }
    }
}
