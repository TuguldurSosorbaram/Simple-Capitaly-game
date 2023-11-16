/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Board;
import assignment.Player.*;

/**
 *
 * @author sutu0
 */
public abstract class Field {
    private String name;
    private int position;
    
    public Field(int position, String name){
        this.position = position;
        this.name = name;
    }
    public int getAmount(){return 0;}
    public String getName(){return this.name;}
    public int getPosition(){return this.position;}
    
    /**
     * Virtual method (default method) currently does nothing
     *
     * @param p Player that is playing right now.

     */
    public void play(Player p){}
}
