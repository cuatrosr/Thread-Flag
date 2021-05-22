package threads;

import model.PrintColors;

public class PrintColorsThread extends Thread {

    public final static String ESC = "\u001b[";

    private PrintColors pc;
    private int lineStart;
    private int size;
    private int x;
    private int wait;

    public PrintColorsThread(PrintColors pc, int lineStart, int size, int wait) {
        this.pc = pc;
        this.lineStart = lineStart;
        this.size = size;
        this.x = 0;
        this.wait = wait;
    }

    public synchronized void advance() {
        for (int i = 0; i < size; i++) {
            int y = i + lineStart;
            System.out.print(ESC + x + "G" + ESC + y + "d" + pc.color());
            try {
                Thread.sleep(wait);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            advance();
            x++;
        }
        System.out.print(ESC + "0m");
    }
}
