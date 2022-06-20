import java.util.Arrays;

public class HWMethods {


    public int[] arrayOneFour(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                if (i == arr.length - 1) {
                    return null;
                }
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("Нет четверок в массиве!");
    }

    public boolean arrayOneAndFour(int[] arr) {
        boolean flagOne = false;
        boolean flagFour = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) {
                flagOne = true;
                continue;
            }
            if (arr[i] == 4) {
                flagFour = true;
            }
        }
        return flagOne && flagFour;
    }
}
