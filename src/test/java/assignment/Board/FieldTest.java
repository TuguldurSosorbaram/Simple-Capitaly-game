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
public class FieldTest {
    
    public FieldTest() {
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
     * Test of play method, of class Field.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Field f = new Property(0,"property");
        Greedy g = new Greedy("Greedy");
        assertEquals(10000,g.getMoney());
        assertEquals(0,g.countProperties());
        f.play(g);
        assertEquals(9000,g.getMoney());
        assertEquals(1,g.countProperties());

    }
    
}
