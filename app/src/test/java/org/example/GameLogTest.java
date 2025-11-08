package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class GameLogTest {
    @Test
    public void testAddWinsAndTies() {
        GameLog log = new GameLog();

        log.addXWin();
        log.addXWin();
        log.addOWin();
        log.addTie();
        log.addTie();

        log.saveToFile("test_log.txt");

        File file = new File("test_log.txt");
        assertTrue(file.exists(), "File should be created");

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            String content = String.join(" ", lines);
            assertTrue(content.contains("Player X Wins: 2"), "Should record 2 X wins");
            assertTrue(content.contains("Player O Wins: 1"), "Should record 1 0 win");
            assertTrue(content.contains("Ties: 2"), "Should record 2 ties");
        } catch (IOException e) {
            fail("Could not read log file");
        } finally {
            file.delete();
        }
    }
}