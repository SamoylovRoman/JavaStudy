package lesson9_enums;

public class DayOfWeekMain {
    public static void main(String[] args) {

        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }
    
    static public int getWorkingHours(DayOfWeek day){
        int hours=0;
        if ((day == DayOfWeek.SATURDAY) || (day == DayOfWeek.SUNDAY)) {
            System.out.println("Выходной день!");
            return 0;
        }
        for (DayOfWeek d: DayOfWeek.values()){
            if (d.ordinal() >= day.ordinal()) {
                hours+=d.getHoursOfWork();
            }
        }
        return hours;
    }
}
