package lesson9_main;

public interface Competitor {
    int MAX_JUMP = 0;
    int MAX_RUN = 0;

    default boolean run(Let let) {
        System.out.println("Ruuun!!");
        return true;
    }

    default boolean jump(Let let) {
        System.out.println("Juuump!!");
        return true;
    }

    boolean isFailed();
}
