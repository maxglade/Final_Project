//Max Glade
//CS110
//Interface to perform functions of a deck of cards 
import java.util.*;
public interface DeckFunction{

   public Card drawCard();
   
   //public static Card compareCard(Card a, Card b);
   
   public void fillDeck();
   
   public boolean isEmpty();
   
   public void shuffleDeck();
   
   
   
}