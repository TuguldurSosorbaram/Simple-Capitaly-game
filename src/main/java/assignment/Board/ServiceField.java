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
public class ServiceField extends Field {
    private int amount;
    
    public ServiceField(int position, int amount){
        super(position, "Lucky Field");
        this.amount = amount;
    }
    @Override
    public int getAmount(){return this.amount;}
    
    /**
     * Overrides play method from the parent
     * calls addMoney function from the player and passes the amount of this field as a parameter
     *
     * @param P Player that is playing right now.
     * @return void
     */
    public void play(Player p){
        p.payServiceFee(this.getAmount());
    }
}
