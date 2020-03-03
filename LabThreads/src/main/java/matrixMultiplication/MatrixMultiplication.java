package matrixMultiplication;

import java.util.Random;

public class MatrixMultiplication {
    public static void main(String[] args){
        Random rnd = new Random();
        int[][] m1 = new int[500] [1000];
        int[][] m2 = new int[1000] [500];
        for (int i=0; i< m1.length; i++){
            for(int j =0; j < m1[i].length; j++){
                m1[i][j] = rnd.nextInt(100) + 1;
                m2[j][i] = rnd.nextInt(100) + 1;
            }
        }
        SingleThreaded.single(m1, m2);
        MultiplicationThreaded.multi(4, m1, m2);
    }
}
