package ui;

import config.GetPropertyValues;
import model.PrintColors;
import threads.PrintColorsThread;

public class Main {

    private static PrintColorsThread[] t = new PrintColorsThread[3];

    public static void main(String[] args) throws InterruptedException {
        GetPropertyValues pv = new GetPropertyValues();
        pv.setColors();
        int[] colors = pv.getColor();

        PrintColors pc1 = new PrintColors(colors[0]);
        PrintColors pc2 = new PrintColors(colors[1]);
        PrintColors pc3 = new PrintColors(colors[2]);

        setThreads(pv, pc1, pc2, pc3);

        System.out.print("\u001b[" + "2J"); //Clear Screen

        startThreads(t);
    }

    public static void setThreads(GetPropertyValues pv, PrintColors pc1, PrintColors pc2, PrintColors pc3) {
        pv.setFirstPart();
        t[0] = new PrintColorsThread(pc1, 1, pv.getLength(), pv.getSleep());
        int aux = pv.getLength() + 1;
        pv.setSecondPart();
        t[1] = new PrintColorsThread(pc2, aux, pv.getLength(), pv.getSleep());
        aux += pv.getLength();
        pv.setThirdPart();
        t[2] = new PrintColorsThread(pc3, aux, pv.getLength(), pv.getSleep());
    }

    public static void startThreads(PrintColorsThread[] t) {
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }
    }
}
