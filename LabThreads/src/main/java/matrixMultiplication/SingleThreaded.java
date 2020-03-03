package matrixMultiplication;

public class SingleThreaded {
    public static void single(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        long m = System.currentTimeMillis();
//        for (int i=0; i<m1.length; i++){
//            for (int j=0; j< m2[0].length; j++){
//                for (int k =0; k < m2.length; k++){
//                    res[i][j] += m1[i][k] * m2[k][j];
//                }
//            }
//        }
        Thread thread = new MatrixThread(m1, m2, res,0, m1.length);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
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
