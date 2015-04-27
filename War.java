//Max Glade
//CS110
//Game Main functions

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*; 

public class War extends Deck{
   private int players;
   private boolean play;
   private ArrayList<Deck> playerDeck;
   private Player[] gamePlayers;
   public Image player1, player2;
   //private ArrayList<Image> cardsDrawnP1, cardsDrawnP2;
   private Deck gameDeck;
   public Image tempImage = new ImageIcon("back.jpg").getImage();
   
   public War(int p){
      gameDeck = new Deck();
      players = p;
      gamePlayers = new Player[p];
      playerDeck = splitDeck(gameDeck, players);
      for(int i=0; i<playerDeck.size(); i++){
         gamePlayers[i] = new Player(playerDeck.get(i));
         }
      player1 = new ImageIcon("back.jpg").getImage();
      //g.drawImage(player1,100,100,null);
      player2 = new ImageIcon("back.jpg").getImage();
      //g.drawImage(player2,900-player2.getWidth(null),100,null);
      play =true;
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
   
   
   public void drawWar(Player[] p, Graphics g){
      ArrayList<Card> draw = new ArrayList<Card>();
      ArrayList<Card> winner = new ArrayList<Card>();
      winner.clear();
      draw.clear();
      g.drawImage(player1,100,100,null);
      g.drawImage(player2,900-player2.getWidth(null),100,null);
      g.setFont(new Font("Arial", Font.BOLD, 18));
      g.drawString("Player 1 Cards: "+ p[0].getPlayerDeck().getCards(),100,50);
      g.drawString("Player 2 Cards: "+ p[1].getPlayerDeck().getCards(),900-player2.getWidth(null),50);
      for(int i=0; i<p.length; i++){
         Card tempDraw = new Card("back",0,0);
         int tempIndex=-1;
         if(!this.getDeck().isEmpty()){
            tempDraw = p[i].getPlayerDeck().drawCard();
         }
         draw.add(tempDraw);
         if(i==0){
            //tempDraw.toStringCard();
            tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
            g.drawImage(tempImage,150+player1.getWidth(null),100,null);
         }else if(i==1){
            tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
            g.drawImage(tempImage,700-player1.getWidth(null),100,null);
         }
         //System.out.print("Player " + i + " drew: ");
         //tempDraw.toStringCard();
         //System.out.println("-------------------------------------");
      }
      winner = compareCard(draw);
      //System.out.println(winner);
      if(winner.size()!=0){
         int winnerIndex = draw.indexOf(winner.get(0));
         for(int q=0; q<draw.size(); q++){
            p[winnerIndex].getPlayerDeck().addCard(draw.get(q));
         }
      }else{
      //System.out.println(draw);
         //System.out.println("WAR");
         //System.out.println("-------------------------------------");
         int rep = 1;
         while(winner.size()==0){
            ArrayList<Card> warCard = new ArrayList<Card>();
            for(int i=0; i<p.length; i++){
               Card tempDraw = new Card("back",0,0);
               if(!this.getDeck().isEmpty()){
                  tempDraw = p[i].getPlayerDeck().drawCard();
               }
               draw.add(tempDraw);
               if(i==0){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,150+player1.getWidth(null),50+player1.getHeight(null),null);
               }else if(i==1){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,700-player1.getWidth(null),50+player1.getHeight(null),null);
               }
               //System.out.print("Player " + i + " drew: ");
               //tempDraw.toStringCard();
               //System.out.println("-------------------------------------");
               if(!this.getDeck().isEmpty()){
                  tempDraw = p[i].getPlayerDeck().drawCard();
               }
               draw.add(tempDraw);
               if(i==0){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,150+player1.getWidth(null),100+player1.getHeight(null),null);
               }else if(i==1){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,700-player1.getWidth(null),100+player1.getHeight(null),null);
               }
               //System.out.print("Player " + i + " drew: ");
               //tempDraw.toStringCard();
               //System.out.println("-------------------------------------");
               if(!this.getDeck().isEmpty()){
                  tempDraw = p[i].getPlayerDeck().drawCard();
               }
               draw.add(tempDraw);
               if(i==0){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,150+player1.getWidth(null),150+player1.getHeight(null),null);
               }else if(i==1){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,700-player1.getWidth(null),150+player1.getHeight(null),null);
               }
               //System.out.print("Player " + i + " drew: ");
               //tempDraw.toStringCard();
               //System.out.println("-------------------------------------");
               if(!this.getDeck().isEmpty()){
                  tempDraw = p[i].getPlayerDeck().drawCard();
               }
               draw.add(tempDraw);
               if(i==0){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,150+player1.getWidth(null),200+player1.getHeight(null),null);
               }else if(i==1){
                  tempImage = (new ImageIcon(tempDraw.getName()+".jpg")).getImage();
                  g.drawImage(tempImage,700-player1.getWidth(null),200+player1.getHeight(null),null);
               }
               //System.out.print("Player " + i + " drew: ");
               //tempDraw.toStringCard();
               //System.out.println("-------------------------------------");
            }
            warCard.add(draw.get(rep+4));
            warCard.add(draw.get(rep+8));
            winner = compareCard(warCard);
            //System.out.println(winner+"war compare");
            if(winner.size()!=0){
               int winnerIndex = warCard.indexOf(winner.get(0));
               for(int q=0; q<draw.size(); q++){
                  p[winnerIndex].getPlayerDeck().addCard(draw.get(q));
               }
               break;
            }
            rep+=8;
         }
      }
      /**p[0].getPlayerDeck().toStringDeck();
      System.out.println("-----------------------------------------");
      p[1].getPlayerDeck().toStringDeck();*/
   }
   
   public Deck getWarDeck(){
      return this.gameDeck;
   }
   
   public boolean gameOver(Player[] p){
      if(p[0].hasLost()||p[1].hasLost()){
         return true;
      }
      else{
         return false;
      }
   }
         
}