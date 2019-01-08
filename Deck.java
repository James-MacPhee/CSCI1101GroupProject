/* 
   CSC1 1101 - Group Project - Deck                
   This is the Deck class,  it has appropriate methods as well as an arraylist and appropriate methods
   Matt Peachey    - B00767172
   James MacPhee   - B00768516
   Craig Spence    - B00
   Scott Macdonald - B00 
*/

import java.util.ArrayList;
import java.util.Collections;

public class Deck{
   
   //Arraylist implements
   private ArrayList<Card> deck = new ArrayList<Card>();
   String[] titles= {"9","10","Jack","Queen","King","Ace"};
      public Deck(){
      for(int i=0;i<4;i++){
         for(int j=9;j<15;j++){
            if(i==0){
               Card c = new Card("Hearts",j,titles[j-9]);
               deck.add(c);
            }
            if(i==1){
               Card c = new Card("Diamd",j,titles[j-9]);
               deck.add(c);
            }
            if(i==2){
               Card c = new Card("Spades",j,titles[j-9]);
               deck.add(c);
            }
            if(i==3){
               Card c = new Card("Clubs",j,titles[j-9]);
               deck.add(c);
            }
         }   
      }
   }   
   public ArrayList<Card> getDeck(){
      return deck;
   }
   
   public void setDeck(ArrayList<Card> deck){
      this.deck = deck;
   }


   public void addCard(Card c){
      deck.add(c);
   }
   
   public String toString(){
      return deck.toString();
   }
   
   //This resets a deck
   public void refresh(){
      deck.clear();
      
   }
   
   //This shuffles the deck
   public void shuffleDeck(){
      Collections.shuffle(deck);
   }
   
}