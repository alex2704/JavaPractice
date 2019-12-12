package sorts;

import ru.vsu.lab.repository.IRepository;

import java.util.Comparator;

public interface ISorter<T> {
    /**
     * sorts array
     * @param arr array of objects
     * @param comparator comparator
     */
    public void sort(T[] arr, Comparator<T> comparator);
}
