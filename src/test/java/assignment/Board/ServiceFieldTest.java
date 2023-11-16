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
public class ServiceFieldTest {
    public ServiceFieldTest() {
    }

//    @org.junit.jupiter.api.BeforeAll
//    public static void setUpClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    public void tearDown() throws Exception {
//    }
    
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
     * Test of play method, of class ServiceField.
     */
    @org.junit.jupiter.api.Test
    public void testPlay() {
        System.out.println("play");
        Player g = new Greedy("greedy");
        Player c = new Careful("careful");
        Player t = new Careful("tactical");
        ServiceField field = new ServiceField(0,2000);
        field.play(g);
        field.play(c);
        field.play(t);
        assertEquals(8000, g.getMoney());
        assertEquals(8000, c.getMoney());
        assertEquals(8000, t.getMoney());
        field = new ServiceField(0,9000);
        field.play(g);
        field.play(c);
        field.play(t);
        assertEquals(0, g.getMoney());
        assertEquals(0, c.getMoney());
        assertEquals(0, t.getMoney());
    }
    
}
