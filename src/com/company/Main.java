package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;
import com.company.Player;
import com.company.InitiatePlayer;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Rock, Papers, Scissors!\n\nType the number 1 or 2 below to select that option:\n1. play another player \n2. play against the computer");
        String competitor = scanner.nextLine();

        boolean gamePlay = true;

        if (competitor.equals("1") || competitor.equals("play another player")) {
            System.out.println("What is your name Player 1?");
            String playerName = scanner.nextLine();
            Player player1 = new InitiatePlayer(playerName, "human", "TBD", 0);
            System.out.println("What is your name Player 2?");
            playerName = scanner.nextLine();
            Player player2 = new InitiatePlayer(playerName, "human", "TBD", 0);
            while (gamePlay == true) {
                // this will check player input & break if input is not rock, paper, scissors
                if (tryCatchCheck(player1, scanner) == false) {
                    break;
                }
                if (tryCatchCheck(player2, scanner) == false) {
                    break;
                }
                String winner = checkWin(player1, player2, player1, player2);
                increment(winner, player1, player2);
                System.out.println(player1.getName() + " win count: " + player1.getWinCount());
                System.out.println(player2.getName() + " win count: " + player2.getWinCount());
                System.out.println("Do you want to play again? (y/n)");
                String gameCheck = scanner.nextLine();
                if (gameCheck.equals("n")) {
                    System.out.println("Final score:");
                    System.out.println(player1.getName() + ": " + player1.getWinCount());
                    System.out.println( player2.getName() + ": " + player2.getWinCount());
                    break;
                }
            }
        } else if (competitor.equals("2") || competitor.equals("play against the computer")) {
            System.out.println("Good luck  - you will now play the computer. What is your name Player 1?");
            String playerName = scanner.nextLine();
            Player player1 = new InitiatePlayer(playerName, "human","TBD", 0);
            Player computer = new InitiatePlayer("computer", "robot", "TBD",0);
            while (gamePlay == true) {
                if (tryCatchCheck(player1, scanner) == false) {
                    break;
                }
                computer.setUserChoice(computer.computerGenerated());
                String winner = checkWin(player1, computer, player1, computer);
                increment(winner, player1, computer);
                System.out.println(player1.getName() + " win count: " + player1.getWinCount());
                System.out.println(computer.getName() + " win count: " + computer.getWinCount());
                System.out.println("Do you want to play again? (y/n)");
                String gameCheck = scanner.nextLine();
                if (gameCheck.equals("n")) {
                    System.out.println("Final score:");
                    System.out.println(player1.getName() + ": " + player1.getWinCount());
                    System.out.println(computer.getName() + ": " + computer.getWinCount());
                    break;
                }
            }
        } else {
            System.out.println("Invalid input, please restart game");
        }

    }

    public static String checkWin(Player player1name, Player player2name, Player player1input, Player player2input) {
        if ((player1input.getUserChoice().equals("rock")) && (player2input.getUserChoice().equals("scissors"))) {
            System.out.println(player1name.getName() + " wins!");
            return player1name.getName();
        }
        else if ((player1input.getUserChoice().equals("scissors")) && (player2input.getUserChoice().equals("paper"))) {
            System.out.println(player1name.getName() + " wins!");
            return player1name.getName();
        }
        else if ((player1input.getUserChoice().equals("paper")) && (player2input.getUserChoice().equals("rock"))) {
            System.out.println(player1name.getName() + " wins!");
            return player1name.getName();
        }
        else if (player1input.getUserChoice().equals(player2input.getUserChoice())) {
            System.out.println("It is a tie!");
            return player1name.getName() + player2name.getName();
        }
        else {
            System.out.println(player2name.getName() + " wins!");
            return player2name.getName();
        }
    }

    public static void increment(String winner, Player player1, Player player2) {
        if (winner == player1.getName()) {
            player1.setWinCount(player1.winCount());
        } else if (winner == player2.getName()){
            player2.setWinCount(player2.winCount());
        } else {
        }
    }

    public static boolean tryCatchCheck(Player playerInput, Scanner scanner) {
        try {
            System.out.println(playerInput.getName() + ", enter rock, paper or scissors:");
            playerInput.setUserChoice(scanner.nextLine().toLowerCase());
            if (playerInput.getUserChoice().equals("rock") || playerInput.getUserChoice().equals("paper") || playerInput.getUserChoice().equals("scissors")) {
            } else {
                throw new java.lang.Error("Throw error");
            }
        } catch (java.lang.Error e) {
            //e.printStackTrace();
            System.out.println("Please restart game, you've enter a bad input");
            return false;
        }
        return true;
    }
}
