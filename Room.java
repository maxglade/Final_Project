//Max Glade
//CS110
//Creates room for game
import java.util.*;
import java.awt.*;
import javax.swing.*;  
public class Room{
private int index = 0;
   public Room(){
      //War game = new War(2);
      
   }
   
   public void draw(Graphics g){
      System.out.println(index);
      //System.out.println(index<Screen.game.getWarDeck().getCards());
      if(index<53){
         g.drawImage(Screen.game.getWarDeck().cardImages.get(index),100,100,Screen.game.getWarDeck().cardImages.get(index).getWidth(null),Screen.game.getWarDeck().cardImages.get(index).getHeight(null),null);
         g.drawImage(Screen.game.getPlayer2(),900-Screen.game.getPlayer2().getWidth(null),100,Screen.game.getPlayer2().getWidth(null),Screen.game.getPlayer2().getHeight(null),null);
      }
      index++;
      
   }
}