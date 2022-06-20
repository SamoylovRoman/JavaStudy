package lesson6;

import lesson6.Animals.Animal;
import lesson6.Animals.Cat;
import lesson6.Animals.Dog;

public class Main {
    public static void main(String[] args) {


        Cat cat = new Cat("Мурзик");
        cat.doRun(50);
        cat.doRun(500);
        Cat cat1 = new Cat("Барсик");
        cat1.doSwim(50);

        Dog dog = new Dog("Шарик");
        dog.doRun(150);
        dog.doRun(510);
        Dog dog1 = new Dog("Мухтар");
        dog1.doSwim(10);
        Dog dog2 = new Dog("Рекс");
        dog2.doSwim(100);

        System.out.println("Всего создано кошек: " + Cat.countCat);
        System.out.println("Всего создано кошек: " + Dog.countDog);
        System.out.println("Всего создано животных: " + Animal.countAnimal);
    }
}
