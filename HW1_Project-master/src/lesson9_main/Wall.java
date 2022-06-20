package lesson9_main;

public class Wall implements Let{
    private int maxValue;

    public int getMaxValue() {
        return maxValue;
    }

    public Wall(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "Wall is " + maxValue;
    }
}
