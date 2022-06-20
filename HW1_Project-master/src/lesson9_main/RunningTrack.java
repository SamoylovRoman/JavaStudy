package lesson9_main;

public class RunningTrack implements Let{
    private int maxValue;

    public int getMaxValue() {
        return maxValue;
    }

    public RunningTrack(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "Running track is " + maxValue;
    }
}
