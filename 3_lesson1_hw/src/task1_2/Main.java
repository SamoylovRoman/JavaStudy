package task1_2;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] masString = {"one", "two", "three", "four", "five", "six"};
        Integer[] masInteger = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        toChange(masString, 2, 0);
        System.out.println(Arrays.toString(masString));

        toChange(masInteger, 0, 6);
        System.out.println(Arrays.toString(masInteger));

        ArrayList<String> sList = arrayToList(masString);
        System.out.println("Строковый список из массива: "+sList.toString());

        ArrayList<Integer> iList = arrayToList(masInteger);
        System.out.println("Целочисленный список из массива: " + iList.toString());

    }

    public static <T> void toChange(T[] mas, int i, int j) {
        T tmp = mas[i];
        mas[i] = mas[j];
        mas[j] = tmp;
    }

    public static <T> ArrayList<T> arrayToList(T[] mas) {
        return new ArrayList<>(Arrays.asList(mas));
    }
}
