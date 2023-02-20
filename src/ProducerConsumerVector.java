import java.util.List;
import java.util.Vector;
public class EX4 {
    public static void main(String[] args) {
        List<String> vector = new Vector<String>();
        Producer producer = new Producer(vector);
        Thread threadProducer = new Thread(producer);
        Consumer consumer = new Consumer(vector);
        Thread threadConsumer = new Thread(consumer);
        threadProducer.start();
        threadConsumer.start();
    }
}

class Producer implements Runnable {
    List<String> vector;
    public Producer(List<String> vector) {
        this.vector = vector;
    }
    public void run() {
        try {
            int count = 0;
            while (true) {
                String s = "String number "+count;
                count++;
                if (count > 100000)
                    count = 0;
                int randomTime = (int) (Math.random() * 501 + 1000);
                Thread.sleep(randomTime);
                while (vector.size() > 10) {
                    Thread.sleep(randomTime);
                }
                vector.add(s);
            }
        } catch (InterruptedException ex) {
        }
    }
}
class Consumer implements Runnable {
    List<String> vector;
    public Consumer(List<String> vector) {
        this.vector = vector;
    }
    public void run() {
        try {
            while (true) {
                if (!vector.isEmpty()) {
                    System.out.println(vector.get(0)+
                            " (" + (vector.size() - 1) + " remaining)");
                    vector.remove(0);
                    int randomTime = (int) (Math.random() * 1001 + 1000);
                    Thread.sleep(randomTime);
                }
            }
        } catch (InterruptedException ex) {
        }
    }
}