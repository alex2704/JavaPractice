package Comparators;

import ru.vsu.lab.entities.IPerson;

import java.util.Comparator;

public class IdComparator<IPerson> implements Comparator<ru.vsu.lab.entities.IPerson> {
    /**
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return 0 если равны, 1 если o1>o2, -1 если o2>o1
     */
    @Override
    public int compare(ru.vsu.lab.entities.IPerson o1, ru.vsu.lab.entities.IPerson o2) {
        if(o1.getId().equals(o2.getId()))
            return 0;
        return o1.getId().compareTo(o2.getId()) > 0 ?  1 : -1;
    }

//    @Override
//    public int compare(IPerson o1, IPerson o2) {
//        if(o1.getId().equals(o2.getId()))
//            return 0;
//        return o1.getId().compareTo(o2.getId()) > 0 ?  1 : -1;
//    }
}
