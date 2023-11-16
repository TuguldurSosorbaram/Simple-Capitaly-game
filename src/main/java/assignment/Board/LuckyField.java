/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Board;

import assignment.Player.Player;

/**
 *
 * @author sutu0
 */
public class LuckyField extends Field {
    private int amount;
    
    public LuckyField(int position, int amount){
        super(position,"Service Field");
        this.amount = amount;
    }
    @Override
    public int getAmount(){return this.amount;}
    
    /**
     * Overrides play method from the parent
     * calls addMoney function from the player and passes the amount of this field as a parameter
     *
     * @param p Player that is playing right now.
     */
    public void play(Player p){
        p.addMoney(this.getAmount());
    }
}
