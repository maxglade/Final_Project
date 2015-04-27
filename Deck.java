//Max Glade
//CS110
//Deck class to hold information about a deck

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Deck implements DeckFunction{
   
   private QueueReferenceBased deckCards;
   private String tempSuite;
   private int numCards;
   private ArrayList<Card> card;
   public static ArrayList<Image> cardImages;
   
   public Deck(){
      this.deckCards = new QueueReferenceBased();
      this.numCards = 52;
      this.card = new ArrayList<Card>();
      this.cardImages  = new ArrayList<Image>();
      fillDeck();
   }
   
   public void setNumCards(){
      numCards = numCards-1;
      }
      
   public Deck(int num){
      this.deckCards = new QueueReferenceBased();
      this.numCards = num;
      this.card = new ArrayList<Card>();
   }
   
   public Card drawCard(){
      if(!this.getDeck().isEmpty()){
         Card drawn = (Card)this.getDeck().dequeue();
         this.numCards-=1;
         this.getDeck().setDeckQueueIndex(this);
         return drawn;
      }
      return new Card("back",0,0);

   }
   
   public void addCard(Card c){
      this.getDeck().enqueue(c);
      this.numCards+=1;
      card.add(c);
      this.getDeck().setDeckQueueIndex(this);
      
   }
   
   public static ArrayList<Card> compareCard(ArrayList<Card> cards){
      ArrayList<Card> maxCards = new ArrayList<Card>();
      if(cards.get(0).getValue()==1&&cards.get(1).getValue()!=2){
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
   
   public void fillDeck(){
      for(int i=1; i<=4; i++){
         for(int j=1; j<=13; j++){
            
            tempSuite="";
            
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
            cardImages.add((new ImageIcon(tempSuite+".jpg")).getImage());
            Card a = new Card(tempSuite,j,0);
            card.add(a);
            }
         }
         cardImages.add((new ImageIcon("back.jpg")).getImage());
         this.shuffleDeck();
      }
         
   public boolean isEmpty(){
      return getCards()==0;
      }
   
   public void shuffleDeck(){
      Collections.shuffle(card);
      for(int i=1; i<=this.getCards(); i++){
         Card tempCard = card.get(i-1);
         tempCard.setIndex(i);
         this.getDeck().enqueue(tempCard);
      }
   }
   
   public static ArrayList<Deck> splitDeck(Deck d, int p){
      ArrayList<Deck> decks = new ArrayList<Deck>();
      int numCards = d.getCards()/p;
      for(int i=0; i<p; i++){
         decks.add(new Deck(0));
         for(int q=1; q<=numCards; q++){
            Card tempCard = d.drawCard();
            tempCard.setIndex(q);
            decks.get(i).addCard(tempCard);
         }
      }
      return decks;
   }   
      
   public int getCards(){
      return numCards;
      }
   
   public QueueReferenceBased getDeck(){
      return deckCards;
   }
   
   public void toStringDeck(){
      this.getDeck().toStringDeckQueue(this);
   }
}