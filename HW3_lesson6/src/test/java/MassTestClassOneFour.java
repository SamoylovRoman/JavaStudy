import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestClassOneFour {
    static HWMethods hw;
    int[] in;
    int[] out;

    @BeforeClass
    public static void prepare() {
        hw = new HWMethods();
    }
    public MassTestClassOneFour(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{1, 2, 0, 0, 2, 3, 0, 1, 4}, null},
                {new int[]{1, 2, 4, 4, 2, 3, 4, 4, 7}, new int[]{7}},
                {new int[]{1, 2, 4, 4, 4, 3, 0, 1, 7}, new int[]{3,0,1, 7}},
                {new int[]{4}, null},
                {new int[]{4, 4}, new int[]{}}
        });
    }



    @Test
    public void testOneFour() {
        Assert.assertArrayEquals(hw.arrayOneFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}), new int[]{1, 7});
    }
}
