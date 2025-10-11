package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("Welcome to Tic-Tac-Toe!");
        boolean playAgain = true;

        while (playAgain) {
            Game game = new Game();
            game.playGame();
            playAgain = InputHelper.askPlayAgain();
        }

        System.out.println("Goodbye!");
  }
}

