package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("Welcome to Tic-Tac-Toe!");
        boolean playAgain = true;
        GameLog log = new GameLog();
        String nextStarter = "X";

        while (playAgain) {
            Game game = new Game(nextStarter);
            String result = game.playGame();

            if(result.equals("X")) {
              log.addXWin();
              nextStarter = "O";
            } else {
              log.addTie();
              nextStarter = nextStarter.equals("X") ? "O" : "X";
            }

            log.printLog();
            playAgain = InputHelper.askPlayAgain();

            if (playAgain) {
              System.out.println("\nGreat! This time" + nextStarter + " will go first!");
            }
        }

        System.out.println("\nWriting the game log to disk. Please see game.txt for the final statistics!");
        log.saveToFile("game.txt");

        System.out.println("Goodbye!");
  }
}

