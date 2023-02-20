public class RaceOfThreads {
    public static void main(String[] args) {
        Thread[] arrayOfThreads = new Thread[10];
        Thread t;
        for (int i = 0; i < 10; i++) {
            t = new Thread(new MyRunnable10(arrayOfThreads));
            arrayOfThreads[i] = t;
            t.start();
        }
    }
}
class MyRunnable10 implements Runnable {
    private long counter;
    private long counter10;
    private Thread[] arrayThreads;
    public MyRunnable10(Thread[] arr) {
        counter = 0;
        counter10 = 0;
        arrayThreads = arr;
    }
    @Override
    public void run() {
        while(!Thread.interrupted() && counter10 < 10000) {
            int aleat = (int) (Math.random() * 11);
            counter ++;
            if (aleat == 10){
                counter10 ++;
            }
            if (counter10 == 10000) {
                System.out.println(Thread.currentThread().getName()
                        + " won after " + counter + " marks");
                for (Thread t : arrayThreads) {
                    t.interrupt();
                }
            }
        }
        if (counter10 < 10000) {
            System.out.println(Thread.currentThread().getName() +
                    " had " + counter10 + " tens and "
                    + counter+ " marks");
        }
    }
}