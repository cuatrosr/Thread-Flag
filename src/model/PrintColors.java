package model;

public class PrintColors {

    public final static String ESC = "\u001b[";
    public final static String UP = ESC + "A";
    public final static String DOWN = ESC + "B";
    public final static String RIGHT = ESC + "C";
    public final static String LEFT = ESC + "D";
    
    private int length;
    private int width;
    private int color;
    private int sleep;
    private int pos;

    public int getWidth() {
        return width;
    }
    
    public void setMouse() {
        System.out.print(ESC + "0G" + ESC + pos + "d");
    }

    public PrintColors(int length, int width, int color, int sleep, int pos) {
        this.length = length;
        this.width = width;
        this.color = color;
        this.sleep = sleep;
        this.pos = pos;
    }

    public void down() throws InterruptedException {
        for (int i = 0; i < length; i++) {
            System.out.print(ESC + color + "m" + " ");
            Thread.sleep(sleep);
            if (i < length - 1) {
                System.out.print(DOWN);
                System.out.print(LEFT);
            } else {
                System.out.print(RIGHT);
                System.out.print(LEFT);
            }
        }
    }

    public void up() throws InterruptedException {
        for (int i = 0; i < length; i++) {
            System.out.print(ESC + color + "m" + " ");
            Thread.sleep(sleep);
            if (i < length - 1) {
                System.out.print(UP);
                System.out.print(LEFT);
            } else {
                System.out.print(RIGHT);
                System.out.print(LEFT);
            }
        }
    }
}
