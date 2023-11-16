/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignment.Board;

import assignment.Player.*;
import java.util.ArrayList;
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
public class BoardTest {
    
    public BoardTest() {
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
     * Test of addField method, of class Board.
     */
    @Test
    public void testAddField() {
        System.out.println("addField");
        Field f = new Property(0,"property");
        Board board = new Board();
        assertEquals(0,board.getFields().size());
        board.addField(f);
        assertEquals(1,board.getFields().size());
    }
    

    /**
     * Test of play method, of class Board.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Field f = new Property(0,"property");
        Board board = new Board();
        assertEquals(0,board.getFields().size());
        board.addField(f);
        Greedy g = new Greedy("Greedy");
        board.play(g, 0);
        assertEquals(0,g.getPos());
        assertEquals(9000,g.getMoney());
        board.play(g, 0);
        assertEquals(0,g.getPos());
        assertEquals(5500,g.getMoney());
        assertEquals(1,g.countProperties());
    }
    
}
