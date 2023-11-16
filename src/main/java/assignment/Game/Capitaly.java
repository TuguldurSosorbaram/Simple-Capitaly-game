/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package assignment.Game;
import assignment.Board.*;
import assignment.Player.*;
import java.util.ArrayList;


/**
 *
 * @author sutu0
 */
public class Capitaly {
    
    public static void main(String[] args) {
        Game gameTest1 = new Game();
        try{
            gameTest1.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/testInput/input1.txt");
            gameTest1.SimulateGameFromDice("D:/UNI/ProgTech/Capitaly/src/testInput/dice1.txt");
        }catch(InvalidInputException e){
            e.printStackTrace();
        }
//        Game game = new Game();
//        try{
//            game.appendItemsFromFile("D:/UNI/ProgTech/Capitaly/src/input.txt");
//        }catch(InvalidInputException e){
//            e.printStackTrace();
//        }
//        while(!game.end()){
//            game.startRound();
//        }
//        game.winnerPrint();

    }

}
