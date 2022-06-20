package lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private boolean isHungry;
    private int amountEat;
    static Random random = new Random();

    public Cat(String name) {
        this.name = name;
        amountEat = random.nextInt(10) + 10;
        isHungry = true;
    }

    public void eat(Plate plate) {
        if (!this.isHungry) {
            System.out.println("Cat " + name + " is full...");
            return;
        }
        if (plate.decreaseFood(this.amountEat)) {
            System.out.println("Cat " + name + " eat...");
            this.isHungry = false;
        } else {
            System.out.println("Cat " + name + " can't eat...");
            this.isHungry = true;
        }
    }

    @Override
    public String toString() {
        return "Cat{" + name +
                ", amountEat=" + amountEat +
                ", isHungry=" + isHungry +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAmountEat() {
        return amountEat;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setAmountEat(int amountEat) {
        this.amountEat = amountEat;
    }
    //    public void fear(Dog dog){
//        System.out.println("Cat "+ name+" fear dog "+ dog.getName());
//    }
}
