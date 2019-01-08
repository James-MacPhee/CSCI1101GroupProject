/* 
   CSC1 1101 - Assignment 3 - Card                 
   This is the Card class,  it has appropriate methods.
   Matt Peachey - B00767172 - March 15th
*/
public class Card{

   private String suit;
   private int rank;
   private String title;
   private int rank2;  
  
   //EMPTY CONSTRUCTOR
   public Card(){}
   
   public Card(String suit, int rank, String title){
      this.suit = suit;
      this.rank = rank;
      this.rank2 = rank;
      this.title= title;
   }
   //To String
   public String toString(){
      return(title + "\nof\n" + suit);
   }
   //Get Methods
   public int getRank(){
      return rank;
   }
   public String getSuit(){
      return suit;
   }
   public String getTitle(){
      return title;
   }
   public int getRank2(){
      return rank2;
   }
   //Set methods
   public void setSuit(String suit){this.suit = suit;}
   public void setRank(int rank){this.rank = rank;}
   public void setRank2(int rank2){this.rank2 = rank2;}
   public void setTitle(String t){this.title=t;}
   
}