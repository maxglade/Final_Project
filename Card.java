//Max Glade 
//CS110
//Card class to hold characteristics of a playing card

public class Card{
   
   /**
      value holds the of the card for comparing cards.
      index is used to correctly order the cards in ArrayLists and Queues.
      name holds the name of the card and its corresponding image file name.
   */
   private int value, index;
   private String name;
   
   
   /**
      Constructor
      Sets name to n, value to v, index to i.
   */
   public Card(String n,int v, int i){
      value = v;
      name = n;
      index = i;
   }
   
   /**
      @return value of the Card.
   */
   public int getValue(){
      return value;
   }
   
   /**
      @return name of the Card.
   */
   public String getName(){
      return name;
   }
   
   /**
      @return index of the Card.
   */
   public int getIndex(){ 
      return index;
   }
   
   /**
      sets index to @param int n
   */
   public void setIndex(int n){
      index = n;
   }
   
   /**
      Method used in testing not actual program.
      prints out Card information.
   */
   public void toStringCard(){
      
      System.out.println("Index: "+getIndex()+ " | " +"Value: "+getValue()+" | Name: "+getName());
   }
   
   
}
