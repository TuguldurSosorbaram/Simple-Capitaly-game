/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Game;

import assignment.Board.*;
import assignment.Player.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Random;
import java.nio.file.Paths;

/**
 *
 * @author sutu0
 */
class InvalidInputException  extends Exception  
{  
    public InvalidInputException (String str)  
    {  
        super(str);  
    }  
}  
public class Game {
    private Board board;
    private ArrayList<Player> players;
    
    private ArrayList<Player> lostPlayers;
    
    
    public Game(){
        this.board = new Board(){};
        this.players = new ArrayList<>();
        this.lostPlayers = new ArrayList<>();
    }
    
    /**
     * Check if player size us less of equal than 1.
     *
     * @return if player size us less of equal than 1.
     */
    public boolean end(){return players.size() <= 1;}
    /**
     * Gives 2 random normal dice rolls and adds them up
     *
     * @return sum of 2 random dice rolls.
     */
    public int diceRoll() {
        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random number between 1 and 6 for each die
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;

        // Calculate the total roll between 2 and 12 (inclusive)
        int totalRoll = die1 + die2;

        return totalRoll;
    }
    /**
     * Parse through text file and gets input
     * 
     * @param filePath path for the file
     * @throws InvalidInputException
     */
    public void appendItemsFromFile(String filePath) throws InvalidInputException {
        Paths.get(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int n = 0;
            int fieldIndex = 0;
            line = br.readLine();
            if(line!=null){
                n = Integer.parseInt(line.trim());
                if(n != Integer.parseInt(line.trim())){
                    throw new NumberFormatException("Could not parse the string as an integer");
                }
                if(n<1){
                    throw new InvalidInputException("Not enough field number given!" );
                }
            }
            while ((line = br.readLine()) != null) {
                n--;
                String[] parts = line.split(" ",2);
                if(!parts[0].equals("L")  && !parts[0].equals("S") && !parts[0].equals("P")){
                    throw new InvalidInputException("Invalid Iinput exception caught" );
                }
                if(parts[0].equals("L")){
                    this.board.addField(
                            new LuckyField(
                                    fieldIndex,
                                    Integer.parseInt(parts[1])));
                    if(this.board.getFields().get(fieldIndex).getAmount() != Integer.parseInt(parts[1])){
                        throw new NumberFormatException("Could not parse the string as an integer");
                    }
                    fieldIndex++;
                }else if(parts[0].equals("S")){
                    this.board.addField(
                            new ServiceField(
                                    fieldIndex,
                                    Integer.parseInt(parts[1])));
                    if(this.board.getFields().get(fieldIndex).getAmount() != Integer.parseInt(parts[1])){
                        throw new NumberFormatException("Could not parse the string as an integer");
                    }
                    fieldIndex++;
                }else{
                    try{
                        this.board.addField(
                                new Property(
                                        fieldIndex,
                                        parts[1]));
                    } catch (NumberFormatException e) {
                        System.err.println("Could not parse the string as an integer: " + e.getMessage());
                    }
                    fieldIndex++;
                }
                if (n == 0)
                    break;
            }
    // reading players
            line = br.readLine();
            if(line!=null){
                n = Integer.parseInt(line.trim());
                if(n != Integer.parseInt(line.trim())){
                    throw new NumberFormatException("Could not parse the string as an integer");
                }
                if(n<1){
                    throw new InvalidInputException("Not enough player number given!" );
                }
            }
            while ((line = br.readLine()) != null) {
                n--;
                String[] parts = line.split(" ",2);
                if(!parts[0].equals("G")  && !parts[0].equals("T") && !parts[0].equals("C")){
                    throw new InvalidInputException("Invalid Iinput exception caught" );
                }
                if(parts[0].equals("G")){
                    this.players.add(new Greedy(parts[1]));
                    fieldIndex++;
                }else if(parts[0].equals("T")){
                    this.players.add(new Tactical(parts[1]));
                    fieldIndex++;
                }else{
                    this.players.add(new Careful(parts[1]));
                    fieldIndex++;
                }
                if (n == 0)
                    break;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch(InvalidPathException ex){
            System.err.println("Error in the path");
        }
    }
    
    /**
     * Removes players from player list if that player is in lost player list
     * 
     */
    public void removePlayers(){
        for(Player p : lostPlayers){
            this.players.remove(p);
        }
    }
    
    /**
     * Goes through each player in the game
     * rolls dice for each player and let the player play.
     * if any player is marked lost after play, 
     * add that player to lost player list and 
     * free all properties from that player and makes the player null.
     * 
     * after enumerating through all players calls removePlayer function.
     */
    public void startRound(){
        int lostCount = 0;
        for(Player player : players){
            if(lostCount != players.size()-1){
                int diceCount = this.diceRoll();
                this.board.play(player, diceCount);

                if(player.isLost()){
                    lostCount++;
                    player.loseProperties();
                    lostPlayers.add(player);
                    player = null;
                }
            } 
        }
        this.removePlayers();
    }
    public void winnerPrint(){
        System.out.println("WINNER: ");
        System.out.println(players.get(0));
    }
    public ArrayList<Integer> readDiceFromFile(String filePath){
        ArrayList<Integer> diceValues = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int n = 6;
                while ((line = br.readLine()) != null) {
                    diceValues.add(Integer.parseInt(line.trim()));
                }
        }catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
        }
        return diceValues;
    }
        public void SimulateGameFromDice(String dicePath){
        ArrayList<Integer> dice = this.readDiceFromFile(dicePath);
        int diceIndex = 0;
        while(!this.end()){
            int lostCount = 0;
            for(Player player : players){
                if(lostCount != players.size()-1){
                    int diceCount = this.diceRoll();
                    this.board.play(player, dice.get(diceIndex));
                    diceIndex++;

                    if(player.isLost()){
                        lostCount++;
                        player.loseProperties();
                        lostPlayers.add(player);
                        player = null;
                    }
                } 
            }
            this.removePlayers();
            this.winnerPrint();
        }
        
    }
    
}
