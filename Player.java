//Max Glade
//CS110
//Player class to hold player stats and current deck
import java.util.*;
public class Player extends Deck{
   
   private boolean lost;      
   private QueueReferenceBased deckQueue;
   private Deck deck;
   
   public Player(Deck playerDeck){
      deck = playerDeck;
      lost = false;
      deckQueue = playerDeck.getDeck();
   }
      
   public Deck getPlayerDeck(){
      return deck;
   }
   
   public QueueReferenceBased getQueue(){
      return deckQueue;
   } 
   
   public void toStringQueue(){
      QueueReferenceBased temp = this.getQueue();
      while(!temp.isEmpty()){
         ((Card)temp.dequeue()).toStringCard();
      }
   }
   
   public boolean hasLost(){
      if(this.getPlayerDeck().isEmpty()){
         return true;
      }
      else{
         return false;
      }
   }
   
   public void toStringPlayer(Player[] p){
      
   }
    
}