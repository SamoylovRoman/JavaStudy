public class Tests {
    public static int COUNT_OF_PRIORITIES = 10;

    @BeforeSuite
    public static void before() {
        System.out.println("It is the before method");
    }

//    @BeforeSuite
//    public static void before1() {
//        System.out.println("It is the before method1");
//    }

    @Test(priority = 1)
    public static void test1() {
        System.out.println("It is the test1");
    }

    @Test(priority = 2)
    public static void test2() {
        System.out.println("It is the test2");
    }

    @Test(priority = 2)
    public static void test3() {
        System.out.println("It is the test3");
    }

    @Test
    public static void test4() {
        System.out.println("It is the test4");
    }

    @Test
    public static void test5() {
        System.out.println("It is the test5");
    }

    @Test(priority = 10)
    public static void test6() {
        System.out.println("It is the test6");
    }

    @AfterSuite
    public static void after() {
        System.out.println("It is the after method");
    }

//    @AfterSuite
//    public static void after1() {
//        System.out.println("It is the after method1");
//    }
}
