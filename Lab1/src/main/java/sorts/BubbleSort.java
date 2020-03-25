package sorts;

import org.apache.log4j.Logger;

import java.util.Comparator;

public class BubbleSort<T> implements ISorter<T>{

    private static Logger logger = Logger.getLogger(BubbleSort.class);

    /**
     * sort mas
     * @param arr - array of objects
     * @param comparator - comparator
     */
    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        logger.trace("BubbleSort started");
        T temp;
        for (int i=0; i<arr.length; i++){
            for (int j = arr.length - 1; j > i; j--){
                if(comparator.compare(arr[j-1], arr[j]) > 0){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
