/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Player;

import assignment.Board.Property;

/**
 *
 * @author sutu0
 */
public class Careful extends Player {
    
    public Careful(String name){
        super(name);
    }
    /**
     * Overrides buyProperty method from the parent
     * buys given property if player has more money than half.
     *
     * @param property Property that player has possibility to buy.
     * @return void
     * @throws NotEnoughMoneyException
     */
    @Override
    public void buyProperty(Property property){
        try{
            if(this.getMoney() > 5000){
                this.payBank(1000);
                property.sold(this);
                this.addProperty(property);
            }
        }catch(NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Overrides buildHouse method from the parent
     * builds house on his own property if player has more money than half.
     *
     * @param property Property that player has possibility to buy.
     * @return void
     * @throws NotEnoughMoneyException
     */
    @Override
    public void buildHouse(Property property){
        try{
            if(this.getMoney() > 5000){
                this.payBank(4000);
                property.build();
            }
        }catch(NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Overrides playProperty method from the parent
     * If property is not owned calls buyProperty,
     * if property is owned by the player calls buildHouse,
     * if property is owned by other player check if property has house or not
     *      if property have house calls payHouse method from parent
     *      if property don't have house, calls payProperty from parent. 
     *
     * @param property Property that player is playing this round.
     * @return void
     */
    @Override
    public void playProperty(Property property){
        if(property.isOwned()){
            if(property.getOwner() == this){
                if(property.getBuilding()){
                    this.addMoney(2000);
                }else{
                    this.addMoney(500);
                    buildHouse(property);
                }
            }else if(property.getBuilding()){
                this.payHouse(property.getOwner());
            }else{
                this.payProperty(property.getOwner());
            }
        }else{
            buyProperty(property);
        }
    }
}
