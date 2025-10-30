package org.example;
import java.util.Scanner;

public class Game {
    public Board board;
    public String currentPlayer;

    public Game(String starter) {
        board = new Board();
        currentPlayer = starter;
    }


    public String playGame() {
        int moves = 0;
        boolean gameWon = false;

        while (!gameWon && moves < 9) {
            board.printBoard();
            int move = InputHelper.getMove(board);
            board.setCell(move - 1, currentPlayer);
            moves++;

            if (checkWinner()) {
                board.printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                return currentPlayer;
            } else if (moves == 9) {
                board.printBoard();
                System.out.println("It's a draw!");
                return "Tie";
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            }

        }

        return "Tie";
    }

    public boolean checkWinner() {
        int[][] wins = {
            {0,1,2},{3,4,5},{6,7,8}, 
            {0,3,6},{1,4,7},{2,5,8}, 
            {0,4,8},{2,4,6}          
        };

        String[] cells = board.getCells();
        for (int[] combo : wins) {
            if (cells[combo[0]] != null &&
                cells[combo[0]].equals(cells[combo[1]]) &&
                cells[combo[1]].equals(cells[combo[2]])) {
                return true;
            }
        }
        return false;
    }
}
