public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        int numMilisec;
        if (args.length==0) {
            System.out.println("Enter the number of seconds to wait: ");
            System.exit(1);
        }
        numMilisec = Integer.valueOf(args[0])*1000;
        MessageLog mLog = new MessageLog("This is the first message",
                "This is the second message",
                "This is the third message",
                "This is the forth message");
        Thread t = new Thread(mLog);
        t.start();
        long accum = 0;
        while (t.isAlive()) {
            Thread.sleep(1000);
            accum += 1000;
            if (accum>=numMilisec)
                t.interrupt();
        }
        System.out.println("The end");
    }
}