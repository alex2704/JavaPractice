package test.labs;

import Exeptions.ReflectException;
import Reflection.Injector;
import com.company.DataMas;
import com.company.Person;
import org.codehaus.plexus.util.reflection.Reflector;
import org.junit.Test;
import sorts.BubbleSort;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class TestReflection {
    /**
     * this method should check proper work of annotation
     */
    @Test
    public void testReflection() throws ReflectException, NoSuchFieldException, IllegalAccessException {
        DataMas<Person> repository = new DataMas<>();
        repository = Injector.inject(repository);
        Field field = repository.getClass().getDeclaredField("sort");
        field.setAccessible(true);
        assertEquals(field.get(repository).getClass(), BubbleSort.class);
    }
}
