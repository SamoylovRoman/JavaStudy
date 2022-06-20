import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MassTestClassOneAndFour {

    static HWMethods hw;
    int[] in;
    boolean out;

    @BeforeClass
    public static void prepare() {
        hw = new HWMethods();
    }

    public MassTestClassOneAndFour(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, false},
                {new int[]{1, 11, 4, 4}, false},
                {new int[]{1, 1}, false},
                {new int[]{1}, false},
                {new int[]{4, 4, 4, 4, 4, 4, 1}, true},
                {new int[]{4, 4}, false}
        });
    }

    @Test
    public void testOneAndFour1() {
        Assert.assertEquals(hw.arrayOneAndFour(in), out);
    }
}
