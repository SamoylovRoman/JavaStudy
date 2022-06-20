package lesson9_main;

import java.util.Random;

public class Main {
    static int MAX_RANDOM_VALUE = 10;

    public static void main(String[] args) {

        Random random = new Random();

        //создаем массив из препятствий
        Let[] letArray = {
                new RunningTrack(random.nextInt(MAX_RANDOM_VALUE)),
                new Wall(random.nextInt(MAX_RANDOM_VALUE)),
                new RunningTrack(random.nextInt(MAX_RANDOM_VALUE)),
                new RunningTrack(random.nextInt(MAX_RANDOM_VALUE)),
                new Wall(random.nextInt(MAX_RANDOM_VALUE))
        };

        for (int i = 0; i < letArray.length; i++) {
            System.out.println(letArray[i].toString());
        }
        System.out.println("----------------------------------");

        //создаем массив из участников
        Competitor[] competitorArray = {
                new Cat(random.nextInt(MAX_RANDOM_VALUE),random.nextInt(MAX_RANDOM_VALUE)),
                new Human(random.nextInt(MAX_RANDOM_VALUE),random.nextInt(MAX_RANDOM_VALUE)),
                new Robot(random.nextInt(MAX_RANDOM_VALUE),random.nextInt(MAX_RANDOM_VALUE)),
        };

        for (int i = 0; i < competitorArray.length; i++) {
            System.out.println(competitorArray[i].toString());
        }
        System.out.println("----------------------------------");

        //участники прыгают/бегают через препятствия
        for (int i = 0; i < letArray.length; i++) {
            for (int j = 0; j < competitorArray.length; j++) {
                if(competitorArray[j].isFailed()){
                    continue;
                }
                if (letArray[i] instanceof RunningTrack) {
                    if (!competitorArray[j].run(letArray[i])){
                        continue;
                    }
                }
                if (letArray[i] instanceof Wall) {
                    if (!competitorArray[j].jump(letArray[i])){
                        continue;
                    }
                }
            }
        }

    }
}
