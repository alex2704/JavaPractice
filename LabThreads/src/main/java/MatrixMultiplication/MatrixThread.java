package MatrixMultiplication;

public class MatrixThread extends Thread{
    private int[][] arr1;
    private int[][] arr2;
    private int[][] sumArr;
    private int begin;
    private int end;

    public MatrixThread(int[][] arr1, int[][] arr2, int[][] sumArr, int begin, int end){
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.sumArr = sumArr;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run(){
        for (int i = begin; i< end; i++){
            for(int j=0; j<arr2[0].length; j++){
                sumArr[i][j] = 0;
                for(int k=0; k< arr2.length; k++){
                    sumArr[i][j] +=  arr1[i][k] * arr2[k][j];
                }
            }
        }
    }
}
