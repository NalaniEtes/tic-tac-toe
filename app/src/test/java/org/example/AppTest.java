package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

  @BeforeEach
  void setUp() {
    App.resetBoard();
  }

  @Test
  void testEmptyBoardHasNoWinner() {
    assertFalse(App.checkWinner(), "An empty board should not have a winner.");
  }

  @Test
  void testRowWin() {
    App.board[0] = "X";
    App.board[1] = "X";
    App.board[2] = "X";

    assertTrue(App.checkWinner(), "Row win should be detected.");
  }

  @Test
  void testColumnWin() {
    App.board[0] = "O";
    App.board[3] = "O";
    App.board[6] = "O";

    assertTrue(App.checkWinner(), "Column win should be detected.");
  }

  @Test
  void testDiagonalWin() {
    App.board[0] = "X";
    App.board[4] = "X";
    App.board[8] = "X";

    assertTrue(App.checkWinner(), "Diagonal win should be detected.");
  }

  @Test
  void testNoWinWithMixedMarks() {
    App.board[0] = "X";
    App.board[1] = "O";
    App.board[2] = "X";

    assertFalse(App.checkWinner(), "Mixed marks should not count as a win.");
  }

  @Test
  void testResetBoardClearsAllCells() {
    App.board[0] = "X";
    App.board[5] = "O";
    App.resetBoard();

    for (int i = 0; i < 9; i++) {
      assertNull(App.board[i], "Board should be cleared after reset.");
    }


  }

  
}
