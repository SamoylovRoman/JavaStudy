package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addEet(int count) {
        this.food+=count;
    }


    public boolean decreaseFood(int amount) {
        if (amount > this.food) {
            return false;
        }
        this.food -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
