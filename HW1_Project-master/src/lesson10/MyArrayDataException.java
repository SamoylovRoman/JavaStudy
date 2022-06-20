package lesson10;

public class MyArrayDataException extends NumberFormatException{
    private int indexI;
    private int indexJ;

    public MyArrayDataException(String s, int indexI, int indexJ) {
        super(s);
        this.indexI = indexI;
        this.indexJ = indexJ;
    }

    public int getIndexI() {
        return indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }
}
