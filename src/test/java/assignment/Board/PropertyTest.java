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
public class PropertyTest {
    
    public PropertyTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Next method");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isOwned method, of class Property.
     */
    @Test
    public void testIsOwned() {
        System.out.println("isOwned");
        Property property = new Property(0,"Property");
        assertEquals(false, property.isOwned());
        Greedy g = new Greedy("Greedy");
        property.play(g);
        assertEquals(true, property.isOwned());
    }
    /**
     * Test of play method, of class Property.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Property p = new Property(0,"Property");
        Player g = new Greedy("greedy");
        Player g2 = new Greedy("greedy2");
        p.play(g);
        assertEquals(g, p.getOwner());
        p.play(g2);
        assertEquals(9500, g2.getMoney());
        p.play(g);
        assertEquals(true, p.getBuilding());
        p.play(g2);
        assertEquals(7500, g2.getMoney());
        assertEquals(8000, g.getMoney());
        
        Player c = new Careful("careful");
        p.play(c);
        assertEquals(8000, c.getMoney());
        Property p2 = new Property(1,"Property2");
        p2.play(c);
        assertEquals(7000, c.getMoney());
        p2.play(c);
        assertEquals(3500, c.getMoney());
        assertEquals(1, c.countProperties());
        Property p3 = new Property(2,"Property3");
        p3.play(c);
        assertEquals(1, c.countProperties());
        
        Player t = new Tactical("tactical");
        p3.play(t);
        assertEquals(1, t.countProperties());
        assertEquals(9000, t.getMoney());
        assertEquals(t,p3.getOwner() );
        p3.play(t);
        assertEquals(false, p3.getBuilding());
        assertEquals(9500, t.getMoney());
        p3.play(t);
        assertEquals(true, p3.getBuilding());
        assertEquals(6000, t.getMoney());

    }
    /**
     * Test of sold method, of class Property.
     */
    @Test
    public void testSold() {
        System.out.println("sold");
        Greedy g = new Greedy("Greedy");
        Property p = new Property(0,"Property");
        assertEquals(p.getOwner(),null);
        p.sold(g);
        assertEquals(p.getOwner(),g);
    }

    /**
     * Test of free method, of class Property.
     */
    @Test
    public void testFree() {
        System.out.println("free");
        Greedy g = new Greedy("Greedy");
        Property p = new Property(0,"Property");
        assertEquals(p.getOwner(),null);
        p.sold(g);
        assertEquals(p.getOwner(),g);
        p.free();
        assertEquals(p.getOwner(),null);
    }
    
}
