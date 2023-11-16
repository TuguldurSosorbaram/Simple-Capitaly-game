/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignment.Player;

import assignment.Board.*;
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
public class CarefulTest {
    
    public CarefulTest() {
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
     * Test of buyProperty method, of class Careful.
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
        Player g = new Careful("Careful");
        assertEquals(null, p.getOwner());
        assertEquals(null, p1.getOwner());
        assertEquals(null, p2.getOwner());
        assertEquals(null, p3.getOwner());
        assertEquals(null, p4.getOwner());
        assertEquals(null, p5.getOwner());
        g.buyProperty(p);
        g.buyProperty(p1);
        g.buyProperty(p2);
        g.buyProperty(p3);
        g.buyProperty(p4);
        g.buyProperty(p5);
        assertEquals(g, p.getOwner());
        assertEquals(g, p1.getOwner());
        assertEquals(g, p2.getOwner());
        assertEquals(g, p3.getOwner());
        assertEquals(g, p4.getOwner());
        assertEquals(null, p5.getOwner());
        
    }

    /**
     * Test of buildHouse method, of class Careful.
     */
    @Test
    public void testBuildHouse() {
        System.out.println("buildHouse");
        Property p = new Property(0,"Property");
        Player c = new Careful("Careful");
        assertEquals(null, p.getOwner());
        c.buyProperty(p);
        assertEquals(c, p.getOwner());
        assertEquals(false, p.getBuilding());
        c.buildHouse(p);
        assertEquals(true, p.getBuilding());
        
    }

    /**
     * Test of playProperty method, of class Careful.
     */
    @Test
    public void testPlayProperty() {
        System.out.println("playProperty");
        Property f = new Property(0,"property");
        Careful g = new Careful("Careful");
        assertEquals(10000,g.getMoney());
        assertEquals(0,g.countProperties());
        f.play(g);
        assertEquals(9000,g.getMoney());
        assertEquals(1,g.countProperties());
        ServiceField f1 = new ServiceField(0,5000);
        f1.play(g);
        f.play(g);
        assertEquals(4500,g.getMoney());
        assertEquals(1,g.countProperties());
    }
    
}
