import java.util.ArrayList;
public class Player{
   
   private Card cardPlayed;
   private String name;
   private int playerNumber;
   private ArrayList<Card> hand = new ArrayList<Card>(5);
   
   Player(String name){
      this.name = name;
   }
   public String toString(){
      return "Player " + playerNumber + "\tName: " + name;
   }
   public String getName(){return name;}
   public int getPlayerNumber(){return playerNumber;}
   public ArrayList<Card> getHand(){return hand;}
   public Card getCardPlayed(){return cardPlayed;}
   
   public void setCardPlayed(Card cardPlayed){this.cardPlayed = cardPlayed;}
   public void setHand(ArrayList<Card> hand){this.hand = hand;}
   public void setName(String name){this.name = name;}
   public void setPlayerNumber(int num){playerNumber = num;}
   
   
}