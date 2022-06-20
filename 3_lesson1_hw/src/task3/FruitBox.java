package task3;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<T extends Friut> {
    public static float CMP_DELTA = 0.0001f;
    private ArrayList<T> fruits;

    public FruitBox(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public FruitBox() {
        this.fruits = new ArrayList<>();
    }


    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public void printBox() {
        System.out.print("\nСодержимое коробки: ");
        for (T fruit : fruits) {
            System.out.print(fruit.getWeight() + "|");
        }
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(FruitBox<?> box) {
        return (this.getWeight() - box.getWeight()) < CMP_DELTA;
    }

    public void pouring(FruitBox<T> box) {
        if (this == box) {
            return;
        }
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
