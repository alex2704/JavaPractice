package Comparators;


import com.company.Person;
import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public class FirstNameComporator<T> implements Comparator<T> {
    /**
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return 0 если равны, 1 если o1>o2, -1 если o2>o1
     */
    @Override
    public int compare(T o1, T o2) {
        if(((Person)o1).getFirstName().equals(((Person)o2).getFirstName()))
            return 0;
        return ((Person)o1).getFirstName().compareTo(((Person)o2).getFirstName()) > 0 ?  1 : -1;
    }
}
