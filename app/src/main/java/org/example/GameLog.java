package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class GameLog {
    private int xWins;
    private int oWins;
    private int ties;

    public GameLog() {
        xWins = 0;
        oWins = 0;
        ties = 0;
    }

    public void addXWin() {
        xWins++;
    }

    public void addOWin() {
        oWins++;
    }

    public void addTie() {
        ties++;
    }

    public void printLog() {
        System.out.println("\nThe current log is:\n");
        System.out.println("Player X Wins  " + xWins);
        System.out.println("Player O Wins  " + oWins);
        System.out.println("Ties           " + ties + "\n");
    }

    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("Final Game Statistics\n");
            writer.write("=====================\n");
            writer.write("Player X Wins: " + xWins + "\n");
            writer.write("Player O Wins: " + oWins + "\n");
            writer.write("Ties: " + ties + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}