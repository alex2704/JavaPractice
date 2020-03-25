package Comparators;

import com.company.Person;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class LastNameComparator<T> implements Comparator<T> {
    private static Logger logger = Logger.getLogger(LastNameComparator.class);
    /**
     *
     * @param o1 object 1
     * @param o2 object 2
     * @return 0 если равны, 1 если o1>o2, -1 если o2>o1
     */
    @Override
    public int compare(T o1, T o2) {
        logger.debug("compare started with " + o1.getClass() + " " + o2.getClass() + " " + "params");
        if(((Person)o1).getLastName().equals(((Person)o2).getLastName()))
            return 0;
        return ((Person)o1).getLastName().compareTo(((Person)o2).getLastName()) > 0 ?  1 : -1;
    }
}
