package shellSort;

import java.util.Random;

public class ShellSort {
    public static void main(String[] args){
        long start;
        long end;
        Random rnd = new Random();
        int[] array = new int[199_997];
        int semi = array.length / 2;
        int[] part1 = new int[semi];
        int[] part2;
        if(semi * 2 != array.length){
            part2 = new int[semi + 1];
        }
        else
            part2 = new int[semi];

        for(int i=0; i< array.length; i++){
            array[i] = rnd.nextInt(10);
            if(i < semi){
                part1[i] = array[i];
            }
            if ( i>= semi){
                part2[i-semi] = array[i];
            }
        }

        try{
            start = System.currentTimeMillis();
            shell(array);
            end = System.currentTimeMillis();
            System.out.println("Однопоточная сортировка заняла: " + (end - start));

            start = System.currentTimeMillis();
            MultithreadedShellSorting mss = new MultithreadedShellSorting(part1, part2);
            mss.getThr().join();
            end = System.currentTimeMillis();
            System.out.println("Многопоточная сортировка заняла: " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void shell(int[] array){
        int length = array.length;
        int semi = length / 2;
        while(semi > 0){
            for(int i = 0; i< length - semi; i++){
                int j = i;
                while((j >= 0) && array[j] > array[j + semi]){
                    int temp = array[j];
                    array[j] = array[j + semi];
                    array[j + semi] = temp;
                    j--;
                }
            }
            semi /= 2;
        }
    }
}
