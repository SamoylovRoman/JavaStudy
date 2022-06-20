package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        goGameSession();
    }

    static void goGame() {

        int sysNum = random.nextInt(10);
        // System.out.printf("Загадали число: %3d\n", sysNum);
        System.out.println("Нужно угадать число от 0 до 9!");
        int userNum;
        int countTry = 3;
        do {

            System.out.print("Число не угадано, введите число ==> ");
            userNum = sc.nextInt();
            countTry--;
            if (userNum < 0 || userNum > 9) {
                System.out.println("Число не попадает в диапазон [0;9]. Давай еще раз!");
                continue;
            }
            if (sysNum > userNum) {
                System.out.println("Загаданное число больше..");
            }
            if (sysNum < userNum) {
                System.out.println("Загаданное число меньше...");
            }
            if (countTry == 0) {
                break;
            }
        } while (userNum != sysNum);
        if (userNum == sysNum) {
            System.out.printf("Молодец! Ты угадал число! Это число %2d\n", sysNum);
        } else {
            System.out.println("ЧИСЛО НЕ УГАДАНО, попыток больше нет!");
        }
    }

    static void goGameSession() {
        int answer;
        do {
            goGame();
            System.out.print("Сыграем еще раз? (0 - НЕТ, 1 - ДА) ==> ");
            answer = sc.nextInt();
            // System.out.printf("Выбарн ответ - %s\n", answer);
        } while (answer != 0);
    }
}