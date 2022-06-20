package lesson9_enums;

public enum DayOfWeek {
    MONDAY(8), TUESDAY(8), WEDNESDAY(8),
    THURSDAY(8), FRIDAY(7),
    SATURDAY(0), SUNDAY(0);

    private int hoursOfWork;

    DayOfWeek(int hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public int getHoursOfWork() {
        return hoursOfWork;
    }

}
