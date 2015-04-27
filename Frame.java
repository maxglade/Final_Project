//Max Glade
//CS110
//JFrame

import javax.swing.*;  
import java.awt.*;

public class Frame extends JFrame{
 
   public static String name = "WAR";
   public static Dimension size = new Dimension(1000, 700);
 
   public Frame(){
      setTitle(name);
      setSize(size);
      setResizable(false);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      inIt();
   }
   
   public void inIt(){
      setLayout(new GridLayout(1,1,0,0));
      
      Screen screen = new Screen();
      add(screen);
      
      setVisible(true);
   }
   
   public static void main(String[]args){
      Frame gameFrame = new Frame();
   }
}