package MatrixMultiplication;

public class SingleThreaded {
    public static void single(int[][] m1, int[][] m2){
        long m = System.currentTimeMillis();
        int[][] res = new int[m1.length][m2[0].length];
        for (int i=0; i<m1.length; i++){
            for (int j=0; j< m2[0].length; j++){
                for (int k =0; k < m2.length; k++){
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        System.out.println("Single threaded program took " + (double) (System.currentTimeMillis() - m));

//        for (int i =0; i < res.length; i++){
//            for (int j = 0; j < res[0].length; j++){
//                System.out.format("%6d", res[i][j]);
//            }
//            System.out.println();
//        }
    }
}
