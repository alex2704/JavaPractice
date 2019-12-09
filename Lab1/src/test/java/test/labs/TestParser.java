package test.labs;

import ParserCsv.ParserCsv;
import com.company.Division;
import com.company.Person;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestParser {

    @Test
    public void testParser() throws IOException {
        Person person = new Person(28290, "Aaralyn", "", Gender.FEMALE,
                LocalDate.of(1993, 3, 20), new BigDecimal(9000), new Division("J"));
        ParserCsv parser = new ParserCsv();
        String path = "src/main/resources/persons.csv";
        parser.read(path);
        IRepository<IPerson> result = parser.parse();
        Assert.assertEquals(person.getId(), result.get(9).getId());
    }
}
