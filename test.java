import java.util.*;

public class test extends Deck{  
   public static void main(String[]args){
      War game = new War(2);
      Player[] players  = game.getPlayers();
      System.out.println(game.cardImages.size());
      /**players[0].getPlayerDeck().toStringDeck();
      System.out.println("-------------------------------------------------");
      players[1].getPlayerDeck().toStringDeck();
      System.out.println("-------------------------------------------------");
      System.out.println("-------------------------------------------------");

      while(!players[0].hasLost()&&!players[1].hasLost()){
         System.out.println("-------------------------------------------------");
         System.out.println("-------------------------------------------------");
         game.drawWar(players);
         //System.out.println("Player 1 has lost: "+players[0].hasLost());
         //System.out.println("Player 2 has lost: "+players[1].hasLost());
      }
      players[0].getPlayerDeck().toStringDeck();
      System.out.println("-------------------------------------------------");
      players[1].getPlayerDeck().toStringDeck();*/

   }
}