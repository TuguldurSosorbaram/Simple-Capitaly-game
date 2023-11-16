/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Board;
import assignment.Player.*;
import java.util.ArrayList;
/**
 *
 * @author sutu0
 */
public class Board {
    private ArrayList<Field> fields;
    
    public Board(){
        this.fields = new ArrayList<>();
    }
    public ArrayList<Field> getFields(){return this.fields;}
    //methods
    /**
    * Adds field to the list of fields of Board
    *
    * @param f field that is to be added.
    * @throws NullPointerException or IllegalArgument exception.
    */
    public void addField(Field f){this.fields.add(f);}
    /**
     * Upgrades player position and calls play method from the new position of the player
     *
     * @param p Player that is playing right now.
     * @param dice Random 2 dice roll number. 
     */
    public void play(Player p,int dice){
        p.setPos((p.getPos() + dice) % this.fields.size());
        fields.get(p.getPos()).play(p);
    }
}
