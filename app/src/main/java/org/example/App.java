package org.example;
import java.util.Scanner;

public class App {
  public static String[] board = new String[9];
  private static String currentPlayer = "X";
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Welcome to Tic-Tac-Toe!");
    boolean playAgain = true;

    while (playAgain) {
      resetBoard();
      playGame();
      playAgain = askPlayAgain();
    }

    System.out.println("Goodbye!");
  }

  private static void playGame() {
    boolean gameWon = false;
    int moves = 0;

    while (!gameWon && moves < 9) {
      printBoard();
      int move = getMove();
      board[move - 1] = currentPlayer;
      moves++;

      if (checkWinner()) {
        printBoard();
        System.out.println("Player " + currentPlayer + " wins!");
        gameWon = true;
      } else if (moves == 9) {
        printBoard();
        System.out.println("It's a draw!");
      } else {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
      }
    }
  }

  private static void printBoard() {
    System.out.println();
    for (int i = 0; i < 9; i++) {
      if (board[i] == null) {
        System.out.print("  " + (i + 1) + "  ");
      } else {
        System.out.print("  " + board[i] + "  ");
      }

      if ((i + 1) % 3 == 0) {
        System.out.println();
        if (i < 8) {
          System.out.println("-----+-----+-----");
        }
      } else {
        System.out.print("|");
      }
    }
    System.out.println();
  }

  public static void resetBoard() {
    for (int i = 0; i < 9; i++) {
      board[i] = null;
    }
    currentPlayer = "X";
  }

  private static int getMove() {
    while (true) {
      System.out.print("What is your move? ");
      String input = scanner.nextLine().trim();

      try {
        int move = Integer.parseInt(input);
        if(move >= 1 && move <= 9) {
          if (board[move - 1] == null) {
            return move;
          } else {
            System.out.println("That cell is already taken! Try again.");
          }
        } else {
          System.out.println("That is not a valid move! Try again.");
        }
      } catch (NumberFormatException e) {
        System.out.println("That is not a valid move! Try again.");
      }
    }
  }

  public static boolean checkWinner() {
    int[][] wins = {
      {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
      {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
      {0, 4, 8}, {2, 4, 6}
    };

    for (int[] combo : wins) {
      if (board[combo[0]] != null &&
      board[combo[0]].equals(board[combo[1]]) &&
      board[combo[1]].equals(board[combo[2]])) {
        return true;
      }
    }
    return false;
  }

  private static boolean askPlayAgain() {
    while (true) {
      System.out.print("Would you like to play again (yes/no)? ");
      String input = scanner.nextLine().trim().toLowerCase();

      if (input.equals("yes")) {
        return true;
      } else if (input.equals("no")) {
        return false;
      } else {
        System.out.println("That is not a valid entry!");
      }
    }
  }
}

