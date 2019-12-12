package sorts;

import com.company.DataMas;
import ru.vsu.lab.repository.IRepository;

import java.util.Comparator;

public class BubbleSort<T> implements ISorter<T>{

    /**
     * sort mas
     * @param arr - array of objects
     * @param comparator - comparator
     */
    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
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
