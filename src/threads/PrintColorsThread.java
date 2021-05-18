package threads;

import model.PrintColors;

public class PrintColorsThread extends Thread {

    private PrintColorsThread[] pct;
    private PrintColors pc;

    public PrintColorsThread(PrintColorsThread[] pct, PrintColors pc) {
        this.pct = pct;
        this.pc = pc;
    }

    @Override
    public void run() {
        synchronized(pct) {
            pc.setMouse();
            try {
                int i = 0;
                while (i < pc.getWidth()) {
                    pc.down();
                    pc.up();
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
