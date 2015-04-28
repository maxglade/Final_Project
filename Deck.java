//Max Glade
//CS110
//Deck class to hold information about a deck

import java.util.*;
import java.awt.*;

public class Deck implements DeckFunction{
   
   //queue for cards to be drawn from and added to
   private QueueReferenceBased deckCards;
   //String to hold the name of a card temporarly as it is Created 
   private String tempSuite;
   //Holds the number of cards in the deck
   private int numCards;
   //ArrayList of cards to fill the deck queue with and shuffle
   private ArrayList<Card> card;
   
   /**
      constructor that sets a basic deck of 52 cards up
   */
   public Deck(){
      this.deckCards = new QueueReferenceBased();
      this.numCards = 52;
      this.card = new ArrayList<Card>();
      fillDeck();//fills deck with 52 cards
   }
   
   /**
      method used to decrement number of cards in the deck by 1
   */
   public void setNumCards(){
      numCards = numCards-1;
      }
   
   /**
      Method to set numCards to @param int n
      used in creating abnormal decks
   */
   public void setCard(int n){
      numCards = n;
   }
   
   /**
      Alternate constructor
      used to create decks of fewer than 52 cards
      used in split deck and is filled using cards from a normal deck
   */   
   public Deck(int num){
      this.deckCards = new QueueReferenceBased();
      this.numCards = num;
      this.card = new ArrayList<Card>();
   }
   
   /**
      Draws a Card from the deck and removes/returns it
   */
   public Card drawCard(){
      if(!this.getDeck().isEmpty()){//checks if deck is empty
         Card drawn = (Card)this.getDeck().dequeue();//draws a card and dequeues it from the Deck queue
         this.numCards-=1;
         this.getDeck().setDeckQueueIndex(this);//reorganizes the index of the cards from 1 to numCards
         return drawn;
      }
      return new Card("back",0,0);//returns "blank" card if there are no more cards to draw

   }
   
   /**
      adds @param Card c to the deck
   */
   public void addCard(Card c){
      this.getDeck().enqueue(c);//enqueue Card c to the deck
      this.numCards+=1;
      card.add(c);//adds Card c to ArrayList of deck
      this.getDeck().setDeckQueueIndex(this);
      
   }
   
   /**
      Used in War class to compare two Card objects in an ArrayList @param cards
      @return the winning Card or an empty ArrayList if the cards are equal
   */
   public static ArrayList<Card> compareCard(ArrayList<Card> cards){
      //Basic algorithm for finding a maximum value but modified to use the card Values.
      ArrayList<Card> maxCards = new ArrayList<Card>();
      if(cards.get(0).getValue()==1&&cards.get(1).getValue()!=2){//2 beats ace
         maxCards.add(cards.get(0));
      }
      else if(cards.get(1).getValue()==1&&cards.get(0).getValue()!=2){
         maxCards.add(cards.get(1));
      }
      else if(cards.get(0).getValue()>cards.get(1).getValue()){
         maxCards.add(cards.get(0));
      }
      else if(cards.get(0).getValue()<cards.get(1).getValue()){
         maxCards.add(cards.get(1));
      }
      return maxCards;
   }
   
   /**
      method to fill a deck with 52 cards
   */
   public void fillDeck(){
      for(int i=1; i<=4; i++){//indices to dictate suite of the card
         for(int j=1; j<=13; j++){//indices to dictate value and part of the name of the card
            
            tempSuite="";
            //these if else statements create the Card's name
            if(i==1){
               tempSuite = "c";
               }
            else if(i==2){
               tempSuite = "d";
               }
            else if(i==3){
               tempSuite = "h";
               }
            else if(i==4){
               tempSuite = "s";
               }
            if(j>=2&&j<=10){
               tempSuite = j+tempSuite;
               }
            else if(j==11){
               tempSuite = "jack"+tempSuite;
               } 
            else if(j==12){
               tempSuite = "queen"+tempSuite;
               }
            else if(j==13){
               tempSuite = "king"+tempSuite;
               }
            else if(j==1){
               tempSuite = "ace"+tempSuite;
               }
            Card a = new Card(tempSuite,j,0);//index is set to 0 because it is decided after the deck ArrayList is shuffled
            card.add(a);
            }
         }
         this.shuffleDeck();//Shuffles the deck so that no two decks will be the same (probably based on statistics no two decks that have been shuffled will be the same)
      }
   
   /**
      @return true if deck has no cards false otherwise
   */     
   public boolean isEmpty(){
      return getCards()==0;
   }
   
   /**
      Method to shuffle a filled deck and set proper indices
   */
   public void shuffleDeck(){
      Collections.shuffle(card);//Shuffles the ArrayList of Card objects
      for(int i=1; i<=this.getCards(); i++){
         Card tempCard = card.get(i-1);
         tempCard.setIndex(i);
         this.getDeck().enqueue(tempCard);//adds Card to queue
      }
   }
   
   /**
      Splits a deck @param d into @param p equal decks 
      for the purpose of this program p will always be 2
      @return ArrayList<Deck> of created Deck objects
   */
   public static ArrayList<Deck> splitDeck(Deck d, int p){
      ArrayList<Deck> decks = new ArrayList<Deck>();
      int numCards = d.getCards()/p;//integer division gives back an equal number of cards to add to each respective deck
      for(int i=0; i<p; i++){//first loop creates a new deck then adds it to the ArrayList of decks
         decks.add(new Deck(0));
         for(int q=1; q<=numCards; q++){//Second loop draws correct number of cards from the initial deck and adds them to the respective Deck ArrayList<Deck>
            Card tempCard = d.drawCard();
            tempCard.setIndex(q);//sets correct index for the card in the deck
            decks.get(i).addCard(tempCard);
         }
      }
      return decks;
   }   
   
   // @return numCards in Deck object
   public int getCards(){
      return numCards;
   }
   
   // @return deckCards queue in Deck object
   public QueueReferenceBased getDeck(){
      return deckCards;
   }
   
   /**
      Method used in testing
      prints the cards in the deck
   */
   public void toStringDeck(){
      this.getDeck().toStringDeckQueue(this);
   }
}