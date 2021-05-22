package model;

public class PrintColors {

    public final static String ESC = "\u001b[";
    private int color;
    private String letter;

    public PrintColors(int color) {
        this.color = color;
        this.letter = " ";
    }

    public String color() {
        String txt = ESC + color + "m" + letter;
        return txt;
    }
}
