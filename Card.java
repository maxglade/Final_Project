//Max Glade 
//CS110
//Card class to hold characteristics of a playing card

public class Card{
   
   private int value, index;
   private String name;
   
   
   
   public Card(String n,int v, int i){
      value = v;
      name = n;
      index = i;
   }
   
   public int getValue(){
      return value;
   }
   
   public String getName(){
      return name;
   }
   
   public int getIndex(){ 
      return index;
   }
   
   public void setIndex(int n){
      index = n;
   }
   
   public void toStringCard(){
      
      System.out.println("Index: "+getIndex()+ " | " +"Value: "+getValue()+" | Name: "+getName());
   }
   
   
}
