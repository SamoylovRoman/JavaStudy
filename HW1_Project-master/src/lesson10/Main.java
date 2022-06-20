package lesson10;

import java.nio.BufferUnderflowException;

public class Main {

    static int ARRAY_SIZE = 4;

    public static void main(String[] args) {

        String[][] w = {
                {"5", "33", "12", "13"},
                {"53", "33", "12", "234"},
                {"2147", "21474", "21474", "234"},
                {"53", "33", "12", "234"},
        };


        try {
            System.out.println(myArrayMethod(w));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.println("Указанный массив не является квадратным с размером " + ARRAY_SIZE);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Ячейка массива, в которой находится НЕ число типа Int: " + e.getIndexI() + ";" + e.getIndexJ());
        }

        System.out.println("END");
    }

    static public long myArrayMethod(String arr[][]) {
        if (arr.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Array's size is not " + ARRAY_SIZE + "x" + ARRAY_SIZE);
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != ARRAY_SIZE) {
                throw new MyArraySizeException("Array's size is not " + ARRAY_SIZE + "x" + ARRAY_SIZE);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Is not Integer value in String cell: [" + i + ";" + j + "]", i, j);
                }
            }
        }
        return sum;
    }
}
