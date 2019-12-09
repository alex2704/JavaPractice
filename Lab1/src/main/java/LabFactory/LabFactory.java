package LabFactory;

import com.company.DataMas;
import com.company.Division;
import com.company.Person;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

public class LabFactory implements ILabFactory {

    /** @return Factory method returning a new Person */
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    /** @return Factory method returning a new Division */
    @Override
    public IDivision createDivision() {
        return new Division();
    }

    /** @return Factory method returning a new repository */
    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {
        return new DataMas<T>();
    }

    @Override
    public IPersonRepository createPersonRepository() {
        return null;
    }
}
