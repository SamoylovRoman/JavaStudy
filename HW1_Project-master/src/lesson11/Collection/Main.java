package lesson11.Collection;

import java.util.*;
import java.util.Random;

public class Main {
    static public int MAX_ARRAY_SIZE = 30;

    public enum Words {
        Mother, House, Pen, Dog, Time, Sister
    }

    public static void main(String[] args) {

        Random random = new Random();

        // создаем и заполняем массив строк через перечисления
        String[] stringArray = new String[MAX_ARRAY_SIZE];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = String.valueOf(Words.values()[random.nextInt(Words.values().length)]);
        }
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + "   ");
        }

        // создаем коллекцию MAP, обходим массив,
        // заносим значения массива в MAP с учетов изменившегося количества
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < stringArray.length; i++) {
            Integer count = hm.getOrDefault(stringArray[i], 0);
            hm.put(stringArray[i], count + 1);
        }
        System.out.println("\n" + hm);

   }
}