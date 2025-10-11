package org.example;
import java.util.Scanner;

public class Board {
    private String[] cells = new String[9];

    public Board() {
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = null;
        }
    }

    public boolean isCellEmpty(int index) {
        return cells[index] == null;
    }

    public void setCell(int index, String player) {
        cells[index] = player;
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(cells[i] == null ? "  " + (i + 1) + "  " : "  " + cells[i] + "  ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
                if (i < 8) System.out.println("-----+-----+-----");
            } else {
                System.out.print("|");
            }
        }
        System.out.println();
    }

    public String[] getCells() {
        return cells;
    }
}
