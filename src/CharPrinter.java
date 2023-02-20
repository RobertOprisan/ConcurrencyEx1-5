public class CharPrinter implements Runnable{
    private char ch;
    private long time;
    public CharPrinter(char ch, long time) {
        this.ch = ch;
        this.time = time;
    }
    public void run() {
        int cont = 0;
        while (true) {
            System.out.print(ch);
            cont++;
            if (cont == 5) {
                System.out.println();
                cont = 0;
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}