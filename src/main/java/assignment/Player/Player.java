/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Player;

import java.util.ArrayList;
import assignment.Board.*;
/**
 *
 * @author sutu0
 */
class NotEnoughMoneyException  extends Exception  
{  
    public NotEnoughMoneyException (String str)  
    {  
        super(str);  
    }  
}  
public abstract class Player {
    //attributes
    private String name;
    private int money;
    private int position;
    private ArrayList<Property> properties;
    private boolean lost;
    
    //constructor
    protected Player(String name){
        this.name = name;
        this.money = 10000;
        this.position = 0;
        this.properties = new ArrayList<>();
        this.lost = false;
    }
    //getter setter
    public int countProperties(){return this.properties.size();}
    public String getName(){return this.name;}
    public boolean isLost(){return this.lost;}
    public void lose(){this.lost = true;}
    public int getPos(){return this.position;}
    public void setPos(int pos){this.position = pos;}
    public int getMoney(){return this.money;}
    public void addMoney(int amount){this.money += amount;}
    /**
     * this player's money will be reduced by the given amount
     *
     * @param amount how much this player has to pay.
     * @throws NotEnoughMoneyException
     */
    public void payBank(int amount) throws NotEnoughMoneyException{
        if(amount > this.money){
             throw new NotEnoughMoneyException("There is not enough money");    
        }
        this.money -= amount;
    }
    /**
     * adds given property to this players list of property.
     *
     * @param property property to be added
     */
    public void addProperty(Property property){this.properties.add(property);}
    //methods
    
    /**
     * this player's money will be reduced by the given amount
     * given players money will be increased by same amount
     *
     * @param p Player that this player has to pay.
     * @param amount how much this player has to pay.
     * @throws NotEnoughMoneyException
     */
    public void pay(Player p, int amount)throws NotEnoughMoneyException{
        if(amount > this.money){
             throw new NotEnoughMoneyException("There is not enough money");    
        }
        this.money -= amount;
        p.addMoney(amount);

    }
    /**
     * Virtual method that does nothing currently.
     *
     * @param p Property that player is playing this round.
     */
    public void playProperty(Property p){}
    
    /**
     * Subtract 2000 from this player money 
     * and adds 2000 to parameter player.
     * If player has less money than 2000, 
     *      player will be marked lost and will pay remaining money to the given player.
     *
     * @param player player that this player has to pay 2000.
     * @throws NotEnoughMoneyException()
     */
    public void payHouse(Player player){
        try{
            if(this.getMoney() > 2000){
                this.pay(player, 2000);
            }else{
                this.pay(player, this.getMoney());
                this.lose();
            }
        }catch(NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
    /**
     * Subtract 500 from this player money 
     * and adds 500 to parameter player.
     * If player has less money than 500, 
     *      player will be marked lost 
     *      and will pay remaining money to the given player.
     *
     * @param player player that this player has to pay 500.
     * @throws NotEnoughMoneyException()
     */
    public void payProperty(Player player){
        try{
            if(this.getMoney() > 500){
                this.pay(player, 500);
            }else{
                this.pay(player, this.getMoney());
                this.lose();
            }
        }catch(NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
    /**
     * Subtract given amount from this player money
     * If player has less money than amount, 
     *      player will be marked lost 
     *      and will pay remaining money to the bank.
     *
     * @param player player that this player has to pay 500.
     * @return void
     * @throws NotEnoughMoneyException
     */
    public void payServiceFee(int amount){
        try{
            if(this.getMoney() > amount){
                this.payBank(amount);
            }else{
                this.payBank(this.getMoney());
                this.lose();
            }
        }catch(NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
    /**
     * Virtual method that does nothing currently
     * it will be overrode depending on the type of player
     *
     * @return void
     */
    public void buyProperty(Property property){}
    /**
     * Virtual method that does nothing currently
     * it will be overrode depending on the type of player
     *
     * @return void
     */
    /**
     * Virtual method that does nothing currently
     * it will be overrode depending on the type of player
     *
     * @return void
     */
    public void buildHouse(Property property){}
    
    /**
     * Change owner of all this players properties to null.
     *
     * @return void
     */
    public void loseProperties(){
        for(Property property : this.properties){
            property.free();
        }
        properties.clear();
    }
    @Override
    public String toString(){
        return "Name: "+this.name + " \nMoney left: " +this.money
                + " Properties count: " + this.properties.size() + " \nProperties: "
                + this.properties.toString();
    }
    
}
