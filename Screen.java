//Max Glade
//CS110
//Screen for use with JPanel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Screen extends JPanel implements Runnable/** Runnable is used to create game loop so threads can easily be regulated */{
   public Thread gameLoop = new Thread(this);//creates a new thread
   public static boolean isFirst = true;//allows for game to be defined in first iteration
   public static int gameWidth, gameHeight, fps;//static ints for dimensions and fps is time threads will sleep for
   public static War game;//Static War object so it can be used across frame and screen
   public static Player[] players;//Player[] to hold game players will always be size 2 for this game
   public static Image backGround = new ImageIcon("Vanilla.jpg").getImage();//creates background image
   
   //Screen Constructor
   //initial fps is set to .5 seconds
   //starts gameLoop which is the thread that runs the game
   public Screen(){
      fps = 500;
      gameLoop.start(); 
   }
   
   /**
      Method to define the elements used in the Screen
   */
   public static void define(){
      game = new War(2);//creates new War with 2 players
      players = game.getPlayers();//sets players = to Player[] of game
      
   }
   
   /**
      method that allows components to be drawn onto the JPanel
   */
   public void paintComponent(Graphics g){
      if(isFirst){ //if is first time painted the Screen components are defined
         define();
         isFirst = false;
      }
      
      g.clearRect(0,0,getWidth(),600);//clears previous screen
      g.drawImage(backGround,0,0,null);//draws background image
      game.drawWar(players,g);//calls drawWar method on game which will paint the components during a game of war
      
      
   } 
   
   /**
      Method needed for Runnable
      this thread dictates game flow
      
   */
   public void run(){
      try{
         Thread.sleep(100); //has thread sleep at start to ensure loop does not start while the frame is opening 
         } catch(Exception e){}
      while(true){
         if(Frame.start){//if start button was pressed this is true
            if(!isFirst){
               if(game.gameOver(players)){//checks if the game is over
                  repaint();//keeps repainting end game screen until window is closed or new game is started
               }
            }
               
            repaint();//repaints components of drawWar
         }
         if(Frame.reStart==true){
            repaint();//repaints components of drawWar on first iteration
            Frame.reStart = false;
         }        
         try{
            Thread.sleep(fps);//has gameLoop sleep for fps/1000 seconds
         } catch(Exception e){}
      }
   }
   
      
}