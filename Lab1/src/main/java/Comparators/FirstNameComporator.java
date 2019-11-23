package Comparators;

import entities.IPerson;

import java.util.Comparator;

public class FirstNameComporator implements Comparator<IPerson> {
    /**
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return 0 если равны, 1 если o1>o2, -1 если o2>o1
     */
    @Override
    public int compare(IPerson o1, IPerson o2) {
        if(o1.getFirstName().equals(o2.getFirstName()))
            return 0;
        return o1.getFirstName().compareTo(o2.getFirstName()) > 0 ?  1 : -1;
    }
}
