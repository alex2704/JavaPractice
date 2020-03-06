package shellSort;

public class Threads extends Thread {
    private int[] array;
    private Thread thr;

    public Threads(int[] array){
        super();
        this.array = array;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run(){
        ShellSort.shell(array);
    }

    public Thread getThr(){
        return thr;
    }
}
