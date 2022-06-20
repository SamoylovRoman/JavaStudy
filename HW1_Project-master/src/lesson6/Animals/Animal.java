package lesson6.Animals;

public class Animal {
    protected String name;
    public static int countAnimal =0;
    protected int swimDist;
    protected int runDist;

    public Animal(String name) {
        this.name = name;
        this.runDist = 0;
        this.swimDist = 0;
        countAnimal++;
    }

    public void doRun(int dist) {
        System.out.println(this.name + " пробежал " + dist + " метров\n");
    }

    public void doSwim(int dist) {
        System.out.println(this.name + " проплыл " + dist + " метров\n");
    }
}
