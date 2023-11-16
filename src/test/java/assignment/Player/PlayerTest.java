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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of payBank method, of class Player.
     */
    @Test
    public void testPayBank() throws Exception {
        System.out.println("payBank");
        Player p = new Greedy("Greedy");
        assertEquals(p.getMoney(), 10000);
        p.payBank(2000);
        assertEquals(p.getMoney(), 8000);
        assertThrows(NotEnoughMoneyException.class, () -> {
            p.payBank(10000);
        });
    }

    /**
     * Test of addProperty method, of class Player.
     */
    @Test
    public void testAddProperty() {
        System.out.println("addProperty");
        Player p = new Greedy("Greedy");
        assertEquals(0, p.countProperties());
        Property prop = new Property(0,"Property");
        p.addProperty(prop);
        assertEquals(1, p.countProperties());
    }

    /**
     * Test of pay method, of class Player.
     */
    @Test
    public void testPay() throws Exception {
        System.out.println("pay");
        Player p = new Greedy("Greedy");
        Player p1 = new Greedy("Greedy");
        assertEquals(p.getMoney(), 10000);
        p.pay(p1,2000);
        assertEquals(p.getMoney(), 8000);
        assertThrows(NotEnoughMoneyException.class, () -> {
            p.pay(p1,10000);
        });
    }
    /**
     * Test of payHouse method, of class Player.
     */
    @Test
    public void testPayHouse() {
        System.out.println("payHouse");
        Player p = new Greedy("Greedy");
        Player p2 = new Greedy("Greedy");
        assertEquals(10000, p.getMoney());
        assertEquals(10000, p2.getMoney());
        p.payHouse(p2);
        assertEquals(8000, p.getMoney());
        assertEquals(12000, p2.getMoney());
        
    }

    /**
     * Test of payProperty method, of class Player.
     */
    @Test
    public void testPayProperty() {
        System.out.println("payProperty");
        Player p = new Greedy("Greedy");
        Player p2 = new Greedy("Greedy");
        assertEquals(10000, p.getMoney());
        assertEquals(10000, p2.getMoney());
        p.payProperty(p2);
        assertEquals(9500, p.getMoney());
        assertEquals(10500, p2.getMoney());
    }

    /**
     * Test of payServiceFee method, of class Player.
     */
    @Test
    public void testPayServiceFee() {
        System.out.println("payServiceFee");
        Player p = new Greedy("Greedy");
        assertEquals(p.getMoney(), 10000);
        p.payServiceFee(2000);
        assertEquals(p.getMoney(), 8000);
    }
    /**
     * Test of loseProperties method, of class Player.
     */
    @Test
    public void testLoseProperties() {
        System.out.println("loseProperties");
        Player p = new Greedy("Greedy");
        assertEquals(0, p.countProperties());
        Property prop = new Property(0,"Property");
        Property prop1 = new Property(0,"Property");
        p.addProperty(prop);
        p.addProperty(prop1);
        assertEquals(2, p.countProperties());
        p.loseProperties();
        assertEquals(0, p.countProperties());
    }

}
