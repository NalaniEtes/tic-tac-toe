package org.example;
import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int getMove(Board board) {
        while (true) {
            System.out.print("What is your move? ");
            String input = scanner.nextLine().trim();

            try {
                int move = Integer.parseInt(input);
                if (move >= 1 && move <= 9) {
                    if (board.isCellEmpty(move - 1)) {
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

    public static boolean askPlayAgain() {
        while (true) {
            System.out.print("Would you like to play again (yes/no)? ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;
            System.out.println("That is not a valid entry!");
        }
    }
}
