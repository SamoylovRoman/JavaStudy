import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClass {
    static HWMethods hw;

    @BeforeClass
    public static void prepare() {
        hw = new HWMethods();
    }

    @Test
    public void testOneFour() {
        Assert.assertArrayEquals(hw.arrayOneFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}), new int[]{1, 7});
    }

    @Test
    public void testOneFour1() {
        Assert.assertArrayEquals(hw.arrayOneFour(new int[]{1, 2, 0, 0, 2, 3, 0, 1, 4}), null);
    }

    @Test(expected = RuntimeException.class)
    public void testOneFour2() {
        hw.arrayOneFour(new int[]{1, 2, 0, 0, 2, 3, 0, 1, 5});
    }

    @Test
    public void testOneAndFour() {
        Assert.assertEquals(hw.arrayOneAndFour(new int[]{1, 1, 1, 4, 4, 1, 4, 4}), true);
    }

    @Test
    public void testOneAndFour1() {
        Assert.assertEquals(hw.arrayOneAndFour(new int[]{1, 1, 1, 1}), false);
    }

    @Test
    public void testOneAndFour2() {
        Assert.assertEquals(hw.arrayOneAndFour(new int[]{4,4,4,4,4,4}), false);
    }

    @Test
    public void testOneAndFour3() {
        Assert.assertEquals(hw.arrayOneAndFour(new int[]{1, 1, 3, 4, 4, 1, 4, 4}), false);
    }
}
