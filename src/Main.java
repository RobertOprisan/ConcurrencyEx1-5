import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Runnable> list = new ArrayList<Runnable>();
        for (char c = 'a'; c <= 'z'; c++) {
            long aleat = (int) (Math.random() * 3000) + 3000;
            CharPrinter charPrinter = new CharPrinter(c, aleat);
            list.add(charPrinter);
        }
        launchThreads(list);
    }
    public static void launchThreads(List<Runnable> list) {
        for (Runnable r: list) {
            Thread t = new Thread(r);
            t.start();
        }
    }
}