//Max Glade
//CS110
//Game Main functions

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*; 

public class War extends Deck{
   //variables for clocking game info
   private int players, repetition=0;
   public long start = System.currentTimeMillis(), end=0, time=0;
   
   //ArrayList to hold Cards
   private ArrayList<Deck> playerDeck;
   //Array to hold Players
   private Player[] gamePlayers;
   //Back of card images
   public Image player1, player2;
   private Deck gameDeck;//creates new deck
   public Image tempImage = new ImageIcon("back.jpg").getImage();
   public Image gameOver = new ImageIcon("black.png").getImage();
   
   /**
      @param p will always be 2 for this game
      Method creates two Player objects and saves them in the Player[]
      also splits deck up accordingly
   */
   public War(int p){
      gameDeck = new Deck();
      players = p;
      gamePlayers = new Player[p];
      playerDeck = splitDeck(gameDeck, players);
      for(int i=0; i<playerDeck.size(); i++){
         gamePlayers[i] = new Player(playerDeck.get(i));
         }
      player1 = new ImageIcon("back.jpg").getImage();
      player2 = new ImageIcon("back.jpg").getImage();
   }
   
   public Player[] getPlayers(){
      return gamePlayers;
   }
   
   public int getNumPlayers(){
      return players;
   }
   
   public Image getPlayer1(){
      return player1;
   }
   
   public Image getPlayer2(){
      return player2;
   }
   
   /**
      This method is the main game algorithm
      it uses the Player objects from @param p
      it goes through the logic of the game war
   */
   public void drawWar(Player[] p, Graphics g){
      ArrayList<Card> draw = new ArrayList<Card>();
      ArrayList<Card> winner = new ArrayList<Card>();
      winner.clear();
      draw.clear();
      //draws player 1 deck
      for(int i=0; i<p[0].getPlayerDeck().getCards(); i++){
         g.drawImage(player1,100,100-i,null);
      }
      //draws player 2 deck
      for(int i=0; i<p[1].getPlayerDeck().getCards(); i++){
         g.drawImage(player2,900-player2.getWidth(null),100-i,null);
      }
      
      //sets font and draws strings displaying information about player variables
      g.setFont(new Font("Arial", Font.BOLD, 18));
      g.drawString("Player 1 Cards: "+ p[0].getPlayerDeck().getCards(),100,40);
      g.drawString("Player 2 Cards: "+ p[1].getPlayerDeck().getCards(),900-player2.getWidth(null),40);
      int tempTotal = p[0].getPlayerDeck().getCards()+p[1].getPlayerDeck().getCards();
      g.drawString("Total: "+ tempTotal,100,500);
      g.drawString("Repetition: "+ repetition/2,100,550);
      
      //checks if game should be played
      if(!this.gameOver(p)&&Frame.start){
         //draws a card from each player
         for(int i=0; i<p.length; i++){
            Card tempDraw = new Card("back",0,0);//creates a temp Card
            int tempIndex=-1;
            if(!this.getDeck().isEmpty()){
               tempDraw = p[i].getPlayerDeck().drawCard();
            }
            draw.add(tempDraw);//adds drawn card to an ArrayList<Card>
            
            //draws images of drawn card for each player
            if(i==0){
               tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
               g.drawImage(tempImage,150+player1.getWidth(null),100,null);
            }else if(i==1){
               tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
               g.drawImage(tempImage,700-player1.getWidth(null),100,null);
            }
            repetition++;
         }
         winner = compareCard(draw);//creates winner ArrayList<card>
         if(winner.size()!=0){//if winner is not empty a player won
            int winnerIndex = draw.indexOf(winner.get(0));//shuffles draw
            Collections.shuffle(draw);
            //adds draw pile to the bottom of winners deck
            for(int q=0; q<draw.size(); q++){
               p[winnerIndex].getPlayerDeck().addCard(draw.get(q));
               //Shows which card won written above the card
               if(winnerIndex==0){
                  g.drawString("WIN",140+(int)(player2.getWidth(null)*(3.0/2)),50);
               }
               else{
                  g.drawString("WIN",840-(int)(player2.getWidth(null)*(3.0/2)),50);
               }
              
            }
         }else{//This means the two cards drawn were equal therefore WAR!!!!!!!!!
            int rep = 1;//used incase of multiple wars to draw cards in correct place
            if(!this.gameOver(p)){
               while(winner.size()==0){
                  g.drawString("WAR!!",480,50);
                  //Same functionality as above with drawing but four cards are drawn
                  ArrayList<Card> warCard = new ArrayList<Card>();
                  for(int i=0; i<p.length; i++){
                     Card tempDraw = new Card("back",0,0);
                     if(!this.getDeck().isEmpty()){
                        tempDraw = p[i].getPlayerDeck().drawCard();
                     }
                     draw.add(tempDraw);
                     
                     if(i==0){
                        tempImage = new ImageIcon("back.jpg").getImage();
                        g.drawImage(tempImage,150+player1.getWidth(null),100+50*(rep/2+1),null);
                     }else if(i==1){
                        tempImage = new ImageIcon("back.jpg").getImage();
                        g.drawImage(tempImage,700-player1.getWidth(null),100+50*(rep/2+1),null);
                     }
                     if(!this.getDeck().isEmpty()){
                        tempDraw = p[i].getPlayerDeck().drawCard();
                     }
                     draw.add(tempDraw);
                     
                     if(i==0){
                        tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                        g.drawImage(tempImage,150+player1.getWidth(null),150+50*(rep/2+1),null);
                     }else if(i==1){
                        tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                        g.drawImage(tempImage,700-player1.getWidth(null),150+50*(rep/2+1),null);
                     }
                  }
                  //since four cards are drawn and multiple repitions are possible these next two lines pick the correct two cards to be compared
                  warCard.add(draw.get(rep+2));
                  warCard.add(draw.get(rep+4));
                  winner = compareCard(warCard);
                  if(winner.size()!=0){
                     //same functionality as before
                     int winnerIndex = warCard.indexOf(winner.get(0));
                     Collections.shuffle(draw);
                     for(int q=0; q<draw.size(); q++){
                        p[winnerIndex].getPlayerDeck().addCard(draw.get(q));
                         if(winnerIndex==0){
                            g.drawString("WIN",140+(int)(player2.getWidth(null)*(3.0/2)),50);
                         }
                         else{
                            g.drawString("WIN",840-(int)(player2.getWidth(null)*(3.0/2)),50);
                         }
   
                     }
                   
                     break;//ends this loop
                  }   
                  rep+=4;
               }
            }
            else{
               //if player has won this is the end game screen
               g.setFont(new Font("Arial", Font.BOLD, 32));
               g.setColor(Color.RED);
               if(p[0].hasLost()){
                  
                  g.drawString("Player 2 has won!!!!",330,350);
               }
               else if(p[1].hasLost()){
                  
                  g.drawString("Player 1 has won!!!!",330,350);
               }
               end = System.currentTimeMillis();
               time = end-start;
               g.setFont(new Font("Arial", Font.BOLD, 18));
               g.setColor(Color.BLACK);
               g.drawString("Total time: "+time+" milliseconds",100,600);
                
               Frame.start = false;
            }
            
         }
      }else{
         //end game screen again if not ended in war
         g.setFont(new Font("Arial", Font.BOLD, 32));
         g.setColor(Color.RED);
         if(p[0].hasLost()){
            
            g.drawString("Player 2 has won!!!!",330,350);
         }
         else if(p[1].hasLost()){
            
            g.drawString("Player 1 has won!!!!",330,350);
         }
         end = System.currentTimeMillis();
         time = end-start;
         g.setFont(new Font("Arial", Font.BOLD, 18));
         g.setColor(Color.BLACK);
         g.drawString("Total time: "+time+" milliseconds",100,600);
         Frame.start = false;
      }
   }
   
   public Deck getWarDeck(){
      return this.gameDeck;
   }
   
   //method to check if either player has lost and if they have corrects an error of showing 53 cards in the win pile due to the "back.jpg" card
   public boolean gameOver(Player[] p){
      if(p[0].hasLost()||p[1].hasLost()){
         if(p[0].hasLost()){
            p[1].getPlayerDeck().setCard(52);
         }
         else{
            p[0].getPlayerDeck().setCard(52);
         }
         return true;
      }
      else{
         return false;
      }
   }
         
}