package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Z2 {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static Random random = new Random();
    static String sysWord = words[random.nextInt(25)];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        goGame();
    }

    static void goGame() {
        String userString;
        do {
            System.out.print("Слово не угадано. Введите слово: ");
            userString = sc.nextLine();
        } while (!cmpWord(userString));
    }

    static boolean cmpWord(String str) {
        int minLength;
        boolean flag = true;
        //System.out.printf("Загаданное имя - %s\n", sysWord);
        char[] ch = str.toCharArray();
        System.out.println(Arrays.toString(ch));
        minLength = Math.min(sysWord.length(), str.length());
        //System.out.printf("Длины слов: %5d %5d\n", sysWordLength, userWordLength);
        char[] chArray = new char[15];
        for (int i = 0; i < minLength; i++) {
            if (str.charAt(i) == sysWord.charAt(i)) {
                chArray[i] = str.charAt(i);
            } else {
                chArray[i] = 'X';
                flag = false;
            }
        }
        if (flag && (str.length()==sysWord.length())) {
            System.out.println("Вы угадали слово!");
            return true;
        }
        for (int i = minLength; i < 15; i++) {
            chArray[i] = 'X';
        }
        System.out.println(Arrays.toString(chArray));
        return false;
    }
}
