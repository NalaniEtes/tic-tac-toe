package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testResetBoard() {
        Board board = new Board();
        board.setCell(0, "X");
        board.setCell(1, "O");

        board.reset();
        for (String cell : board.getCells()) {
            assertNull(cell, "All cells should be null after reset");
        }
    }

    @Test
    public void testSetAndIsCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0), "Cell 0 should be empty initially");

        board.setCell(0, "X");
        assertFalse(board.isCellEmpty(0), "Cell 0 should not be empty after setting X");
    }
}
