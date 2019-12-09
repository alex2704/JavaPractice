package test.labs;

import LabFactory.LabFactory;
import org.junit.Assert;
import org.junit.Test;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

public class TestLabFactory {
    LabFactory labFactory = new LabFactory();

    @Test
    public void testCreatePerson(){
        IPerson person = labFactory.createPerson();
        Assert.assertTrue(person instanceof IPerson);
    }

    @Test
    public void testCreateDivision(){
        IDivision div = labFactory.createDivision();
        Assert.assertTrue(div instanceof IDivision);
    }

    @Test
    public void testCreateRepository(){
        IRepository repos = labFactory.createRepository(IPerson.class);
        Assert.assertTrue(repos instanceof  IRepository);
    }

}
