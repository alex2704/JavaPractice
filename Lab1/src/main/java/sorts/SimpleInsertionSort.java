package sorts;

import org.apache.log4j.Logger;

import java.util.Comparator;

public class SimpleInsertionSort<T> implements ISorter<T>{

    private static Logger logger = Logger.getLogger(SimpleInsertionSort.class);
    /**
     * sort array
     * @param arr array of objects
     * @param comparator comparator
     */
    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        logger.trace("SimpleInsertionSort started");
        for (int i = 1; i < arr.length + 1; i++){
            T current = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(current, arr[j]) < 0){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}
