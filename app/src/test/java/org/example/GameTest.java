package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testCheckWinnerRow() {
        Game game = new Game("X");

        game.board.setCell(0, "X");
        game.board.setCell(1, "X");
        game.board.setCell(2, "X");

        assertTrue(game.checkWinner(), "X should win with top row");
    }

    @Test
    public void testCheckWinnerColumn() {
        Game game = new Game("O");

        game.board.setCell(0, "O");
        game.board.setCell(3, "O");
        game.board.setCell(6, "O");

        assertTrue(game.checkWinner(), "O should win with first column");
    }

    @Test
    public void testCheckWinnerDiagonal() {
        Game game = new Game("X");

        game.board.setCell(0, "X");
        game.board.setCell(4, "X");
        game.board.setCell(8, "X");

        assertTrue(game.checkWinner(), "X should win with diagonal");
    }

    @Test
    public void testNoWinner() {
        Game game = new Game("X");

        game.board.setCell(0, "X");
        game.board.setCell(1, "O");
        game.board.setCell(2, "X");

        assertFalse(game.checkWinner(), "No winner yet");
    }
}
