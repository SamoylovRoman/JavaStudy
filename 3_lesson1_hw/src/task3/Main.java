package task3;


public class Main {
    public static void main(String[] args) {
//        FruitBox<Apple> box = new FruitBox(new Apple(), new Apple(), new Orange());

        FruitBox<Apple> box1 = new FruitBox<>();
        //добавим 15 яблок в коробку
        for (int i = 0; i < 15; i++) {
            box1.addFruit(new Apple());
        }
        box1.printBox();
        System.out.println("\nВес коробки с яблоками: " + box1.getWeight());

        FruitBox<Orange> box2 = new FruitBox<>();
        //добавим 10 апельсинов в коробку
        for (int i = 0; i < 10; i++) {
            box2.addFruit(new Orange());
        }
        box2.printBox();
        System.out.println("\nВес коробки с апельсинами: " + box2.getWeight());

        System.out.println("\nКоробки равны? => " + box1.compare(box2));

        //добавляем одно яблоко в коробку
        box1.addFruit(new Apple());
        System.out.println("\nА сейчас равны? => " + box1.compare(box2));

        FruitBox<Orange> box3 = new FruitBox<>();
        //еще одна коробка с 3 апельсинами
        for (int i = 0; i < 3; i++) {
            box3.addFruit(new Orange());
        }

        //пересыпим из второй коробки в третью
        box2.pouring(box3);
        box2.printBox();
        box3.printBox();

        //Фанзиль, вопрос к Вам. А почему так могу создать коробку?
        // Коробку с разными фруктами в одной. Не понимаю что-то
        // в таком случае дженерики не работают? если писать new FruitBox<Apple>(...
        // тогда только ругается. Но на сколько я где-то прочитал, что явное указание
        // указание типа в <> с каокой-то версии необязательно? или я что-то путаю?
        FruitBox<Apple> box = new FruitBox(new Apple(), new Apple(), new Orange());
        box.printBox();
    }
}
