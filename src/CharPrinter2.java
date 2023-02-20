public class CharPrinter2 implements Runnable{
    private char ch;
    private long time;
    public CharPrinter2(char ch, long time) {
        this.ch = ch;
        this.time = time;
    }
    public void run() {
        try {
            int cont = 0;
            while (true) {
                System.out.print(ch);
                cont++;
                if (cont == 5) {
                    System.out.println();
                    cont = 0;
                }
                Thread.sleep(time);
            }
        } catch(InterruptedException ex) {
            System.out.println("\n"+ch+" interrupted");
            return;
        }
    }
}