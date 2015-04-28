//Max Glade
//CS110
//Player class to hold player stats and current deck
import java.util.*;
public class Player extends Deck{
   
   //boolean lost used to see if a player has lost and if a game should continue
   private boolean lost;  
   //Queue to hold the deck for drawing    
   private QueueReferenceBased deckQueue;
   //Deck to hold queue and card information
   private Deck deck;
   
   /**
      constructor
      @param Deck playerDeck is created at the start of the game
   */
   public Player(Deck playerDeck){
      deck = playerDeck;
      lost = false;
      deckQueue = playerDeck.getDeck();
   }
   
   /**
      @return Player deck
   */
   public Deck getPlayerDeck(){
      return deck;
   }
   
   /**
      @return deckQueue of the Player
   */
   public QueueReferenceBased getQueue(){
      return deckQueue;
   } 
   
   
   /**
      method used in testing.
      dequeue and prints Card.
   */
   public void toStringQueue(){
      QueueReferenceBased temp = this.getQueue();
      while(!temp.isEmpty()){
         ((Card)temp.dequeue()).toStringCard();
      }
   }
   
   /**
      @return true if player deck is empty
      @return false if Player deck is not empty
   */
   public boolean hasLost(){
      if(this.getPlayerDeck().isEmpty()){
         return true;
      } 
      else{
         return false;
      }
   }   
}