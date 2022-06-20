package lesson6.Animals;

public class Cat extends Animal {
    public static int countCat = 0;


    public Cat(String name) {
        super(name);
        this.runDist = 200;
        this.swimDist = 0;
        countCat++;
    }

    @Override
    public void doSwim(int dist) {
        System.out.println(this.name + ". Кошки не умеют плавать!");
    }

    @Override
    public void doRun(int dist) {
        if (dist <= runDist) {
            System.out.println("Кошка " + this.name + " пробежала " + dist + " метров");
        } else {
            System.out.println("Кошка " + this.name + " не пробежит " + dist + " метров");
        }
    }

}
