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
public class Tactical extends Player {
    private int chance;
    
    public Tactical(String name){
        super(name);
        this.chance = 0;
    }
    
    /**
     * Overrides buyProperty method from the parent
     * buys given property on every second chance.
     *
     * @param property Property that player has possibility to buy.
     * @return void
     * @throws NotEnoughMoneyException
     */
    @Override
    public void buyProperty(Property property){
        try{
            if(this.getMoney() > 1000){
                if(chance%2 ==0){
                    this.payBank(1000);
                    property.sold(this);
                    this.addProperty(property);
                }

                chance++;
            }
        }catch(NotEnoughMoneyException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Overrides buildHouse method from the parent
     * builds house on his own property on every second chance.
     *
     * @param property Property that player has possibility to buy.
     * @return void
     * * @throws NotEnoughMoneyException
     */
    @Override
    public void buildHouse(Property property){
        try{
            if(this.getMoney() > 4000){
                if(chance%2 ==0){
                    this.payBank(4000);
                    property.build();
                }
                chance++;
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
