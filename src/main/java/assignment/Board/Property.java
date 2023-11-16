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
public class Property extends Field {
    private Player owner;
    private boolean building;
    
    public Property(int position, String name){
        super(position,name);
        this.owner = null;
        this.building = false;
    }
    public boolean isOwned(){return this.owner != null;}
    public Player getOwner(){return this.owner;}
    public void setOwner(Player p){this.owner = p;}
    public boolean getBuilding(){return this.building;}
    public void setBuilding(boolean b){this.building = b;}
    //methods
    
    /**
     * Overrides play method from the parent
     * calls playProperty function from the player 
     * because how they play differs from what type of player it is
     * and passes the amount of this field as a parameter.
     *
     * @param p Player that is playing right now.
     */
    @Override
    public void play(Player p){
        p.playProperty(this);
    }
    public void build(){this.building = true;}
    
    /**
     * Changes the owner of this property to given player.
     *
     * @param p Player that will own the property.
     */
    public void sold(Player p){this.owner = p;}
    
    /**
     * Set the owner to null and building to false.
     */
    public void free(){
        this.setOwner(null);
        this.setBuilding(false);
    }
    @Override
    public String toString(){
        if(this.building){
            return "\nProperty name: " + this.getName() + " with building\nPosition: " + this.getPosition();
        }
        return "\nProperty name: " + this.getName() + " without building\nPosition: " + this.getPosition();
    }
}
