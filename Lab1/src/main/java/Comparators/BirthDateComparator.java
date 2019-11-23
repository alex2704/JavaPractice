package Comparators;

import entities.IPerson;

import java.util.Comparator;

public class BirthDateComparator implements Comparator<IPerson> {

    /**
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return 0 если равны, 1 если o1>o2, -1 если o2>o1
     */
    @Override
    public int compare(IPerson o1, IPerson o2) {
        if(o1.getAge().equals(o2.getAge()))
            return 0;
        return o1.getAge().compareTo(o2.getAge()) > 0 ?  1 : -1;
    }
}
