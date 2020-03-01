package MatrixMultiplication;

public class MultiplicationThreaded {
    public static void multi(int threadsCount, int[][]m1, int[][]m2){
        Thread[] threads = new Thread[threadsCount];
        int per = (int) m1.length / threadsCount;
        int[][] res = new int[m1.length][m2[0].length];
        long m = System.currentTimeMillis();

        for(int i=0; i < threadsCount; i++){
            threads[i] = new MatrixThread(m1, m2, res,per*(i), per*(i + 1));
            threads[i].start();
        }
        for (Thread one : threads){
            try{
                one.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Multi thread took " + (double) (System.currentTimeMillis() - m));
//        for (int i =0; i < res.length; i++){
//            for (int j = 0; j < res[0].length; j++){
//                System.out.format("%6d", res[i][j]);
//            }
//            System.out.println();
//        }
    }
}
