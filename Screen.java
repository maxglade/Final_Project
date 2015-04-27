//Max Glade
//CS110
//Screen for use with JPanel
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Screen extends JPanel implements Runnable{
   public Thread gameLoop = new Thread(this);
   public static boolean isFirst = true;
   public static int gameWidth, gameHeight;
   public static Room room;
   public static War game;
   public static Player[] players;
   public static Image backGround = new ImageIcon("Vanilla.jpg").getImage();
   public Screen(){
      gameLoop.start(); 
      
   }
   
   public void define(){
      game = new War(2);
      players = game.getPlayers();
      
   }
   
   public void paintComponent(Graphics g){
      if(isFirst){ 
         define();
         isFirst = false;
      }
      
      g.clearRect(0,0,getWidth(),getHeight());
      g.drawImage(backGround,0,0,null);
      game.drawWar(players,g);
      
      
   } 
   
   public void run(){
      while(true){
         if(!isFirst){
            if(game.gameOver(players)){
               this.setBackground(Color.BLACK);
               repaint();
               break;
            }
         }
         
         repaint();         
         try{
            Thread.sleep(1000);
         } catch(Exception e){}
      }
   }
   
      
}