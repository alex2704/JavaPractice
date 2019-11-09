package test.labs;

import com.company.Person;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class TestPersonMethods {
    /**
     * getAge method should return age person in years depending on his birthday
     */
    @Test
    public void testGetAge(){
        Person person1 = new Person(1, "Иван", "Прыткин", "Васильевич", "м",
                new LocalDate(2004, 4, 27));
        Person person2 = new Person(1, "Иван", "Прыткин", "Васильевич", "м",
                new LocalDate(2004, 12, 27));
        Assert.assertEquals(15, person1.getAge());
        Assert.assertEquals(14, person2.getAge());
    }
}
