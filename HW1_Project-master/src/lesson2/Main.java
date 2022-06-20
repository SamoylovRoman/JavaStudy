package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Задание №1
        System.out.println("*** Задание №1 ***");
        int[] arr01 = {0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(arr01));
        doReverse(arr01);
        System.out.println(Arrays.toString(arr01));

        // Задание №2
        System.out.print("\n*** Задание №2 ***\n");
        int[] arr2 = new int[8];
        completeArr(arr2);
        System.out.println(Arrays.toString(arr2));

        // Задание №3
        System.out.print("\n*** Задание №3 ***\n");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        min6upX2(arr3);
        System.out.println(Arrays.toString(arr3));

        // Задание №4
        System.out.print("\n*** Задание №4 ***\n");
        int n = 6;
        int[][] arr4 = new int[n][n];
        print2DArray(arr4);
        setDiagOne(arr4);
        print2DArray(arr4);

        // Задание №5
        System.out.print("\n*** Задание №5 ***\n");
        int[] arr5 = {233, -4, 5, 6, 8, -300, 67, 6};
        System.out.println("Массив: " + Arrays.toString(arr5));
        System.out.printf("Минимальное значение из массива: %d\n", minOfArray(arr5));
        System.out.printf("Максимальное значение из массива: %d\n", maxOfArray(arr5));

        // Задание №6
        System.out.print("\n*** Задание №6 ***\n");
        int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.print("Массив: " + Arrays.toString(arr6));
        System.out.printf(" Этот массив имеет баланс - %b\n", checkBalance(arr6));
        int[] arr61 = {2};
        System.out.print("Массив: " + Arrays.toString(arr61));
        System.out.printf(" Этот массив имеет баланс - %b\n", checkBalance(arr61));
        int[] arr62 = {2, 2};
        System.out.print("Массив: " + Arrays.toString(arr62));
        System.out.printf(" Этот массив имеет баланс - %b\n", checkBalance(arr62));
        int[] arr63 = {1, 1, 1, 2, 1};
        System.out.print("Массив: " + Arrays.toString(arr63));
        System.out.printf(" Этот массив имеет баланс - %b\n", checkBalance(arr63));
        int[] arr64 = {1, 1, 1, 2, 1, 1};
        System.out.print("Массив: " + Arrays.toString(arr64));
        System.out.printf(" Этот массив имеет баланс - %b\n", checkBalance(arr64));

        // Задание №7
        System.out.print("\n*** Задание №7 ***\n");
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Исходный массив: " + Arrays.toString(arr7));
        shiftArray(arr7,-5);
        System.out.println("Сдвинули на -5: " + Arrays.toString(arr7));
        shiftArray(arr7,3);
        System.out.println("Сдвинули на 3: " + Arrays.toString(arr7));
        shiftArray(arr7,0);
        System.out.println("Сдвинули на 0: " + Arrays.toString(arr7));
        shiftArray(arr7,-12);
        System.out.println("Сдвинули на -12: " + Arrays.toString(arr7));
    }

    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0
//
    static void doReverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i] != 1) {
                System.out.println("В массиве есть не только 0 и 1!");
                continue;
            }
            if (arr[i] == 0)
                arr[i] = 1;
            else arr[i] = 0;
        }
    }

    //    2. Задать пустой целочисленный массив размером 8.
//    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
//
    static void completeArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//    пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static void min6upX2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
    }

    //    4. Создать квадратный двумерный целочисленный массив
//    (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
//    заполнить его диагональные элементы единицами;
    static void print2DArray(int[][] arr) { // метод печати двумерного массива
        System.out.println("Содержимое массива:");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%5s", anInt);
            }
            System.out.print("\n");
        }
    }

    static void setDiagOne(int[][] arr) { // диагональные элементы - единицы
        for (int i = 0, k = arr.length - 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                    arr[i][k] = 1;
                    k--;
                }
            }
        }
    }

    //    5. ** Задать одномерный массив и найти в нем минимальный
//    и максимальный элементы (без помощи интернета);
    static int minOfArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    static int maxOfArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    //    6. ** Написать метод, в который передается не пустой одномерный
//    целочисленный массив, метод должен вернуть true, если в массиве
//    есть место, в котором сумма левой и правой части массива равны.
//    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
//    эти символы в массив не входят.
    static boolean checkBalance(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int sum1 = arr[i];
        int sum2 = arr[j];
        while ((j - i) > 1) {
            if (sum1 <= sum2) {
                i++;
                sum1 += arr[i];
                continue;
            }
            if (sum2 < sum1) {
                j--;
                sum2 += arr[j];
                continue;
            }
        }
        if (i == j) return false;
        return sum1 == sum2;
    }

    //    7. **** Написать метод, которому на вход подается одномерный массив и число n
//            (может быть положительным, или отрицательным), при этом метод должен
//    сместить все элементымассива на n позиций. Для усложнения задачи нельзя
//    пользоваться вспомогательными массивами.
    static void shiftLeft(int[] arr) { // сдвигает элементы массива на одну позицию влево
        int tmp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = tmp;
    }

    static void shiftRight(int arr[]) { // сдвигает элементы массива на одну позицию вправо
        int tmp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;
    }

    static void shiftArray(int arr[], int n) {
        if (n == 0) return;
        if (n > 0)
            for (int i = 0; i < n; i++) {
                shiftRight(arr);
            }
        else
            for (int i = 0; i < -n; i++) {
                shiftLeft(arr);
            }
    }
}

