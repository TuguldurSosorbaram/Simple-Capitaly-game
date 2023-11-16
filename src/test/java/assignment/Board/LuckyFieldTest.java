/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignment.Board;

import assignment.Player.*;
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
public class LuckyFieldTest {
    
    public LuckyFieldTest() {
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
     * Test of play method, of class LuckyField.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Player g = new Greedy("greedy");
        Player c = new Careful("careful");
        Player t = new Careful("tactical");
        LuckyField field = new LuckyField(0,2000);
        field.play(g);
        field.play(c);
        field.play(t);
        assertEquals(12000, g.getMoney());
        assertEquals(12000, c.getMoney());
        assertEquals(12000, t.getMoney());
        field = new LuckyField(0,0);
        field.play(g);
        assertEquals(12000, g.getMoney());
        assertEquals(12000, c.getMoney());
        assertEquals(12000, t.getMoney());
    }
    
}
