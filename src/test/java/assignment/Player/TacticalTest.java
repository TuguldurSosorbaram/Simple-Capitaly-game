/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignment.Player;

import assignment.Board.Property;
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
public class TacticalTest {
    
    public TacticalTest() {
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
     * Test of buyProperty method, of class Tactical.
     */
    @Test
    public void testBuyProperty() {
        System.out.println("buyProperty");
        Property p = new Property(0,"Property");
        Property p1 = new Property(0,"Property");
        Property p2 = new Property(0,"Property");
        Property p3 = new Property(0,"Property");
        Property p4 = new Property(0,"Property");
        Property p5 = new Property(0,"Property");
        Player g = new Tactical("Tactical");
        assertEquals(null, p.getOwner());
        g.buyProperty(p);
        g.buyProperty(p1);
        g.buyProperty(p2);
        g.buyProperty(p3);
        g.buyProperty(p4);
        g.buyProperty(p5);
        assertEquals(g, p.getOwner());
        assertEquals(null, p1.getOwner());
        assertEquals(g, p2.getOwner());
        assertEquals(null, p3.getOwner());
        assertEquals(g, p4.getOwner());
        assertEquals(null, p5.getOwner());
    }

    /**
     * Test of buildHouse method, of class Tactical.
     */
    @Test
    public void testBuildHouse() {
        System.out.println("buildHouse");
        Property p = new Property(0,"Property");
        Player t = new Tactical("Tactical");
        assertEquals(null, p.getOwner());
        t.buyProperty(p);
        assertEquals(t, p.getOwner());
        assertEquals(false, p.getBuilding());
        t.buildHouse(p);
        assertEquals(false, p.getBuilding());
        t.buildHouse(p);
        assertEquals(true, p.getBuilding());
    }

    /**
     * Test of playProperty method, of class Tactical.
     */
    @Test
    public void testPlayProperty() {
        System.out.println("playProperty");
        Property f = new Property(0,"property");
        Tactical g = new Tactical("Tactical");
        assertEquals(10000,g.getMoney());
        assertEquals(0,g.countProperties());
        f.play(g);
        assertEquals(9000,g.getMoney());
        assertEquals(1,g.countProperties());
    }
    
}
