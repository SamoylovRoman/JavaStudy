import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        HWMethods hw = new HWMethods();
        int[] mas = {1, 4, 5, 6, 7, 4, 6, 4, 6, 5};
        int[] mas1 = {1, 0, 5, 6, 7, 0, 6, 0, 6};
        int[] mas2 = {4, 1, 7, 5,};

        try {

            System.out.println(Arrays.toString(hw.arrayOneFour(mas)));
            System.out.println(Arrays.toString(hw.arrayOneFour(mas1)));
            System.out.println(Arrays.toString(hw.arrayOneFour(mas2)));
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }

        int[] arr = {1, 4, 4, 4, 1};
        int[] arr1 = {1, 1, 1, 1, 1, 1};
        int[] arr2 = {4, 1, 2, 1, 1, 4, 4, 1};

        System.out.println(hw.arrayOneAndFour(arr));
        System.out.println(hw.arrayOneAndFour(arr1));
        System.out.println(hw.arrayOneAndFour(arr2));

    }


}
