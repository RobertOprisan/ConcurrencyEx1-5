import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        List<Runnable> list = new ArrayList<Runnable>();
        for (char c='a'; c<='z'; c++) {
            long aleat = (int) (Math.random() * 3000) + 3000;
            CharPrinter charPrinter = new CharPrinter(c,aleat);
            list.add(charPrinter);
        }
        launchThreads(list);
    }
    public static void launchThreads(List<Runnable> list) {
        final ArrayList<Thread> listThreads = new ArrayList<Thread>();
        for (Runnable r: list) {
            Thread t = new Thread(r);
            listThreads.add(t);
            t.start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Thread t: listThreads) {
                    long aleat = (int) (Math.random() * 20001) + 10000;
                    try {
                        Thread.sleep(aleat);
                    } catch (InterruptedException ex) {
                    }
                    t.interrupt();
                }
            }
        }).start();
    }
}