package lesson6.Animals;

public class Dog extends Animal {
    public static int countDog = 0;

    public Dog(String name) {
        super(name);
        this.runDist = 500;
        this.swimDist = 10;
        countDog++;
    }

    @Override
    public void doRun(int dist) {
        if (dist <= runDist) {
            System.out.println("Собака " + this.name + " пробежала " + dist + " метров");
        } else {
            System.out.println("Собака " + this.name + " не пробежит " + dist + " метров");
        }
    }

    @Override
    public void doSwim(int dist) {
        if (dist <= swimDist) {
            System.out.println("Собака " + this.name + " проплыла " + dist + " метров");
        } else {
            System.out.println("Собака " + this.name + " не проплывет " + dist + " метров");
        }
    }
}
