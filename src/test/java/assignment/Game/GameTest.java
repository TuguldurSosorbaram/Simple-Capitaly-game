/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignment.Game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sutu0
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    /**
     * Test of appendItemsFromFile method, of class Game.
     */
    @Test
    public void testAppendItemsFromFile() throws Exception {
        System.out.println("appendItemsFromFile");
        Game game = new Game();
        game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/input.txt");
        assertEquals(game.end(), false);
        assertThrows(InvalidInputException.class, () -> {
            game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/fail1.txt");
        });
        assertThrows(NumberFormatException.class, () -> {
            game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/fail2.txt");
        });
        assertThrows(NumberFormatException.class, () -> {
            game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/fail3.txt");
        });
        assertThrows(NumberFormatException.class, () -> {
            game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/fail4.txt");
        });
        assertThrows(InvalidInputException.class, () -> {
            game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/fail5.txt");
        });
        
    }
    
}
