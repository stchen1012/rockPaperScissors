package com.company;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Player {
    private String name;
    private String type;
    private String userChoice;
    private int winCount;

    Player() {

    }

    Player(String name, String type, String userChoice, int winCount) {
        this.name = name;
        this.type = type;
        this.userChoice = userChoice;
        this.winCount = winCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public String computerGenerated() {
        String arr[] = {"rock", "paper", "scissors"};
        Random random  = new Random();
        int randomNumber = random.nextInt(arr.length);
        System.out.println(arr[randomNumber]);
        return arr[randomNumber];

//        List<String> randomValue = new ArrayList<String>();
//        randomValue.add("rock");
//        randomValue.add("paper");
//        randomValue.add("scissors");
//        Random random = new Random();
//        IntStream.range(0,1).forEach(a -> System.out.println(randomValue.get(random.nextInt(randomValue.size()))));
//        //return randomValue.get(random.nextInt(randomValue.size()));
    }

    public int winCount() {
        winCount++;
        return winCount;
    }

}
