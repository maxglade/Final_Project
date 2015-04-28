//Max Glade
//CS110
//JFrame

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame{
   //set up variables for JFrame
   public static String name = "WAR";
   public static Dimension size = new Dimension(1000, 700);
   private JPanel buttonPanel;//JPanel for JButtons
   public Screen screen;
   private JButton buttonStart,buttonStop, buttonSpeed, buttonSlow, newGame;
   //booleans to control if game is running or not and what loops are iterating
   public static boolean start = false, reStart = false;
 
   public Frame(){
      //sets up JFrame
      setTitle(name);
      setSize(size);
      setResizable(false);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      inIt();//adds components 
   }
   
   //builds button panel and adds buttons and respective ActionListeners
   private void buildButtonPanel(){
      buttonPanel = new JPanel();
      buttonPanel.setBackground(Color.BLACK);
      buttonPanel.setLayout(new GridLayout(1,5,10,0));//1 row 5 columns for 5 buttons
      buttonStart = new JButton("Start War");
      buttonStop = new JButton("Pause War");
      buttonSpeed = new JButton("Speed up war");
      buttonSlow = new JButton("Slow down war");
      newGame = new JButton("Start new game");
      buttonStart.addActionListener(new ButtonListenerStart());
      buttonStop.addActionListener(new ButtonListenerStop());
      buttonSpeed.addActionListener(new ButtonListenerSpeed());
      buttonSlow.addActionListener(new ButtonListenerSlow());
      newGame.addActionListener(new ButtonListenerNewGame());
      buttonPanel.add(buttonStart);
      buttonPanel.add(buttonStop);
      buttonPanel.add(buttonSpeed);
      buttonPanel.add(buttonSlow);
      buttonPanel.add(newGame);
   }
   
   private class ButtonListenerNewGame implements ActionListener{
      public void actionPerformed(ActionEvent e){
         reStart = true;//stops first draw
         start = false;//allows for redifine of Screen in run() loop
         Screen.isFirst = true;//allows redifine of screen
      }
   }
   
   private class ButtonListenerSlow implements ActionListener{
      public void actionPerformed(ActionEvent e){
         Screen.fps+=50;//slows run() loop by .2 seconds
      }
   }
   
   private class ButtonListenerSpeed implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(Screen.fps-50<=0){//makes sure fps >0
            Screen.fps=50;//minimum loop pause to prevent crash or errors in code 
         }else{
            Screen.fps-=50;//speeds loop by .2 seconds
         }
      }
   }
   
   private class ButtonListenerStart implements ActionListener{ 
      public void actionPerformed(ActionEvent e){
         start = true;//allows game loop to start
      }
   }
   
   private class ButtonListenerStop implements ActionListener{
      public void actionPerformed(ActionEvent e){
         start = false;//pauses game loop and game
      }
   }
   
   public void inIt(){
      //sets layout of JFrame to a BorderLayout
      setLayout(new BorderLayout());
      screen = new Screen();//instaniates a new Screen object
      add(screen,BorderLayout.CENTER);//adds screen to center which displays the game
      buildButtonPanel();
      add(buttonPanel,BorderLayout.SOUTH);//adds button panel to bottom of screen
      setVisible(true);
   }
   
   public static void main(String[]args){
      Frame gameFrame = new Frame();//starts game
   }
}