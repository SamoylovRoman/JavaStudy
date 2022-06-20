package lesson1;

public class Main {
    public static void main(String[] args) {
        byte bArg = 125;
        short sArg = 12344;
        int iArg = 3456789;
        long lArg = 1234512345;
        float fArg = -1123.3456f;
        double dArg = -14.76597598;
        char chArg = 'R';
        boolean boolArg = true;

        System.out.print("\n**** Метод a * (b + (c / d)) ****\n");
        System.out.println(methodCalc(1, 2, 1, 3));
        System.out.printf("a * (b + (c / d)) = %.5f \n", methodCalc(1, 2, 1, 3));

        System.out.print("\n**** Сумма в интервале (10;20] ****\n");
        System.out.printf("Сумма чисел %d b %d попадает в интервал (10;20]? - %b\n", 7, 6, sumInInterval1020(7, 6));
        System.out.printf("Сумма чисел %d b %d попадает в интервал (10;20]? - %b\n", 17, 6, sumInInterval1020(17, 6));
        System.out.printf("Сумма чисел %d b %d попадает в интервал (10;20]? - %b\n", 15, 5, sumInInterval1020(15, 5));

        System.out.print("\n**** Положительное ли число ****\n");
        isPosOrNot(0);
        isPosOrNot(5);
        isPosOrNot(-7);

        System.out.print("\n**** Отрицательное ли число ****\n");
        System.out.printf("%d - отрицательное число? - %b\n", 0, isNegativ(0));
        System.out.printf("%d - отрицательное число? - %b\n", 5, isNegativ(5));
        System.out.printf("%d - отрицательное число? - %b\n", -7, isNegativ(-7));

        System.out.print("\n**** Привет, _имя_ ****\n");
        printName("Ева");
        printName("Игорь");
        printName("Светлана");

        System.out.print("\n**** Високосный год? ****\n");
        isLeapYear(2000);
        isLeapYear(2004);
        isLeapYear(2100);
        isLeapYear(2020);
        isLeapYear(2021);
    }

    static double methodCalc(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    static boolean sumInInterval1020(int arg1, int arg2) {
        int sum = arg1 + arg2;
        return sum > 10 && sum <= 20;
    }

    static void isPosOrNot(int arg) {
        if (arg >= 0)
            System.out.printf("%d - это положительное число\n", arg);
        else
            System.out.printf("%d - это отрицательное число\n", arg);
    }

    static boolean isNegativ(int arg) {
        return arg < 0;
    }

    static void printName(String name) {
        System.out.printf("Привет, %s\n", name);
    }

    static void isLeapYear(int year) {

        if (year % 400 == 0) {
            System.out.printf("%d-й год является високосным\n", year);
            return;
        }
        if (year % 100 == 0 && year % 400 != 0) {
            System.out.printf("%d-й год не является високосным\n", year);
            return;
        }
        if (year % 4 == 0)
            System.out.printf("%d-й год является високосным\n", year);
        else
            System.out.printf("%d-й год не является високосным\n", year);
    }
}
