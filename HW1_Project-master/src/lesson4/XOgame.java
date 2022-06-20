package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOgame {
    static final int SIZE = 7;
    static final int DOT_TO_WIN = 3;


    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили! Поздравляем!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println(" Комп!");
            //aiTurn();
            aiBlockTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил.");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("input X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) { // доработка условия
            return false;
        }
        return map[y][x] == DOT_EMPTY;
//        if (map[y][x] == DOT_EMPTY) {
//            return true;
//        } else {
//            return false;
//        }
    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static void aiBlockTurn() { // ход компьютера с блокировкой победы игрока

        for (int i = 0; i < SIZE; i++) { // идем по всем точкам
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) { // если ячейка валидная
                    map[i][j] = DOT_X; // фиктивно ставим ход игрока в эту ячеку
                    if (checkWin(DOT_X)) { // проверяем, победит ли он, если эта ячека будет его ходом
                        map[i][j] = DOT_O; // если побеждает, ставим сюда ход компьютера
                        return; // выходим из метода
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        aiTurn(); // компьютер ходит по умолчанию без блокировки
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Доработанный метод проверки победы
    public static boolean checkWin(char c) {
        boolean flagWin; // флаговая переменная false - нет нужного количества точек для победы, true - есть
        int countSize; // количество точек подряд для победы (счетчик)

        for (int i = 0; i < SIZE; i++) { // проверка горизонтальных линий победы
            countSize = 0;
            flagWin = true;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[i][j] == c) { // если ячейка нужного нам знака
                    countSize++;
                    if (map[i][j] != map[i][j + 1]) {
                        flagWin = false;
                        break;
                    }
                    if (countSize == DOT_TO_WIN - 1) break;
                }
                //System.out.println("Счетчик" + countSize);
            }
            //System.out.println("Счетчик = " + countSize + " Флаг = " + flagWin);
            if (flagWin && countSize == DOT_TO_WIN - 1) return true;
        }

        for (int i = 0; i < SIZE; i++) { // проверка вертикальных линий победы
            countSize = 0;
            flagWin = true;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[j][i] == c) {
                    countSize++;
                    if (map[j][i] != map[j + 1][i]) {
                        flagWin = false;
                        break;
                    }
                    if (countSize == DOT_TO_WIN - 1) break;
                }
                //System.out.println("Счетчик = " + countSize + " Флаг = " + flagWin);
            }
            //System.out.println("Счетчик = " + countSize + " Флаг = " + flagWin);
            if (flagWin && countSize == DOT_TO_WIN - 1) return true;
        }

        for (int i = 0; i <= SIZE - DOT_TO_WIN; i++) { // проверка диагональных (прямых) линий победы
            for (int j = 0; j <= SIZE - DOT_TO_WIN; j++) {
                flagWin = true;
                countSize = 0;
                if (map[i][j] == c) {
                    for (int k = 1; k < DOT_TO_WIN; k++) {
                        countSize++;
                        if (map[i][j] != map[i + k][j + k]) {
                            flagWin = false;
                            break;
                        }
                    }
                    if (flagWin && countSize == DOT_TO_WIN - 1) return true;
                }
            }
        }

        for (int i = 0; i <= SIZE - DOT_TO_WIN; i++) { // проверка диагональных (обратных) линий победы
            for (int j = SIZE - 1; j >= SIZE - DOT_TO_WIN; j--) {
                flagWin = true;
                countSize = 0;
                if (map[i][j] == c) {
                    for (int k = 1; k < DOT_TO_WIN; k++) {
                        countSize++;
                        if (map[i][j] != map[i + k][j - k]) {
                            flagWin = false;
                            break;
                        }
                    }
                    if (flagWin && countSize == DOT_TO_WIN - 1) return true;
                }
            }
        }

        return false;
    }

}
