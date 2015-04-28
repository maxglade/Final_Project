//Max Glade
//CS110
//Interface to perform functions of a deck of cards 
 
import java.util.*;
public interface DeckFunction{

   /**
      method to take a card from the top of a deck/dequeue from a Deck queue
   */
   public Card drawCard();
   
   /**
      Will fill a Deck object with Card objects
   */
   public void fillDeck();
   
   /**
      will check if a deck has no Card objects
      @return true if the deck is empty false otherwise
   */
   public boolean isEmpty();
   
   /**
      will shuffle a Deck objects cards
   */
   public void shuffleDeck();
   
   
   
}