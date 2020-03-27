package test.labs;

import JAXB.Jaxb;
import ParserCsv.ParserCsv;
import com.company.DataMas;
import com.company.Division;
import com.company.Person;
import org.junit.Test;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import javax.xml.bind.JAXBException;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.jar.JarException;

public class TestJaxb {
    @Test
    public void testToXml() throws JAXBException, IOException {
        Person person = new Person(28290, "Aaralyn", "", Gender.FEMALE,
                LocalDate.of(1993, 3, 20), new BigDecimal(9000), new Division("J"));
        ParserCsv parser = new ParserCsv();
        String path = "src/main/resources/persons.csv";
        parser.read(path);
        IRepository<IPerson> result = parser.parse();
        File file = new File("src/main/resources/person.xml");
        Jaxb.toXml(result, file.getPath());
    }

    @Test
    public void testFromXml() {
        DataMas<Person> mas = new DataMas<>();
        mas = (DataMas<Person>) Jaxb.fromXml("src/main/resources/person.xml", DataMas.class);
        System.out.println(mas.toString());
    }
}
