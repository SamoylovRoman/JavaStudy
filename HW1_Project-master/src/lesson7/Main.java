package lesson7;

public class Main {
    public static void main(String[] args) {

        Cat[] arrayCats = new Cat[5];
        arrayCats[0] = new Cat("Barsik");
        arrayCats[1] = new Cat("Kuzya");
        arrayCats[2] = new Cat("Murzik");
        arrayCats[3] = new Cat("Obby");
        arrayCats[4] = new Cat("Felix");
        Plate plate = new Plate(50);
        for (int i = 0; i < arrayCats.length; i++) {
            System.out.println(arrayCats[i].toString());
        }
        System.out.println(plate);
        for (int i = 0; i < arrayCats.length; i++) {
            arrayCats[i].eat(plate);
            System.out.println("Кот " + arrayCats[i].getName() + " голоден? - " + arrayCats[i].isHungry());
        }
        System.out.println(plate);
        System.out.println("\nДобавим еды в тарелку");
        plate.addEet(50);
        System.out.println(plate);
        System.out.println("\nЕще раз поедим");
        for (int i = 0; i < arrayCats.length; i++) {
            arrayCats[i].eat(plate);
            System.out.println("Кот " + arrayCats[i].getName() + " голоден? - " + arrayCats[i].isHungry());
        }
        System.out.println(plate);
//        Cat cat = new Cat("Barsik");
//        Plate plate = new Plate(100);
//        System.out.println("Кот голоден? - " + cat.isHungry());
//        System.out.println("Кот ест максимум " + cat.getAmountEat());
//        cat.eat(plate);
//        System.out.println("КОт голоден? - " + cat.isHungry());
//        System.out.println(plate);
    }
}
