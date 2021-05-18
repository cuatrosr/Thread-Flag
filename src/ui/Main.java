package ui;

import config.GetPropertyValues;
import java.io.IOException;
import model.PrintColors;
import threads.PrintColorsThread;

public class Main {

    private static final PrintColorsThread[] threads = new PrintColorsThread[3];
    private static int posMouse = 0;
    
    public static void main(String[] args) throws InterruptedException, IOException {
        GetPropertyValues pv = new GetPropertyValues();
        System.out.println(pv.getSleep());
        System.out.print("\u001b[" + "2J");//Clear screen
        
        pv.setFirstPart();
        PrintColors p1 = new PrintColors(pv.getLength(), pv.getWidth(), pv.getColor(), pv.getSleep(), 0);
        
        posMouse = pv.getLength();
        
        pv.setSecondPart();
        PrintColors p2 = new PrintColors(pv.getLength(), pv.getWidth(), pv.getColor(), pv.getSleep(), posMouse + 1);
        
        posMouse += pv.getLength();
        
        pv.setThirdPart();
        PrintColors p3 = new PrintColors(pv.getLength(), pv.getWidth(), pv.getColor(), pv.getSleep(), posMouse + 1);
        
        setThreads(p1, p2, p3);
        startThreads();
    }

    public static void setThreads(PrintColors p1, PrintColors p2, PrintColors p3) {
        threads[0] = new PrintColorsThread(threads, p1);
        threads[1] = new PrintColorsThread(threads, p2);
        threads[2] = new PrintColorsThread(threads, p3);
    }

    public static void startThreads() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
