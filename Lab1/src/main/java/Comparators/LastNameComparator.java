package Comparators;

import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public class LastNameComparator<T> implements Comparator<IPerson> {
    /**
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return 0 если равны, 1 если o1>o2, -1 если o2>o1
     */
    @Override
    public int compare(IPerson o1, IPerson o2) {
        if(o1.getLastName().equals(o2.getLastName()))
            return 0;
        return o1.getLastName().compareTo(o2.getLastName()) > 0 ?  1 : -1;
    }
}
