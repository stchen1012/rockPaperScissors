package com.company;

import java.util.Random;

public class InitiatePlayer extends Player {

    InitiatePlayer(String name, String type, String userChoice, int winCount) {
        super(name, type, userChoice, winCount);
    }

    @Override
    public String computerGenerated() {
        String arr[] = {"rock", "paper", "scissors"};
        Random random  = new Random();
        int randomNumber = random.nextInt(arr.length);
        System.out.println(arr[randomNumber]);
        return arr[randomNumber];
    }
//        List<String> randomValue = new ArrayList<String>();
//        randomValue.add("rock");
//        randomValue.add("paper");
//        randomValue.add("scissors");
//        Random random = new Random();
//        IntStream.range(0,1).forEach(a -> System.out.println(randomValue.get(random.nextInt(randomValue.size()))));
//        //return randomValue.get(random.nextInt(randomValue.size()));

}
