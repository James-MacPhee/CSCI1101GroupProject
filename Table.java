/* The way our table works is that we construct a table with two teams with two players each repectively.
The game is played in this order.
1. Method: Deal(). Adds cards to all the hands.
2. Method: settingTrump(): We ask every player if they wish to pick up or pass. We set the trump here.
3. Method: CreateRanks(). Our create ranks class uses our setTrump to make the ranking list for the round. 
*/
import java.util.*;
public class Table{

   private int count = 1;
   private int turn;  
   private Deck deck;
   public String trump;
   private Team t1, t2;
   private String suitLead;
   private int winner = 0;
   private String winnerS = "";
   private Card card1,card2,card3,card4,leftOver;
   
   Scanner kb= new Scanner(System.in);      
   public Table(){}
   //CONSTRUCTOR
   public Table(Team t1, Team t2, Deck d){
      this.t1 = t1;
      this.t2 = t2;
      this.deck = d;
   }  
   //Creating ranks depending on trumps
   public void createRanks(){    
      resetRanks();
      if(trump.equals("Hearts")){
         for(int i=0;i<24;i++){
            if(deck.getDeck().get(i).getSuit().equals("Hearts")){
               if(deck.getDeck().get(i).getRank()==11){
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*100);
               }
               else{
                  deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*10);
               }
            }
            if(deck.getDeck().get(i).getSuit().equals("Diamd")){
               if(deck.getDeck().get(i).getRank()==11){
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*50);
               }
            }
            if(count==0){
               deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2());
            }
         }
      }
      
      
      
      else if(trump.equals("Diamd")){
         for(int i=0;i<24;i++){
            if(deck.getDeck().get(i).getSuit().equals("Diamd")){
               if(deck.getDeck().get(i).getRank()==11){
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*100);
               }
               else{
                  deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*10);
               }
            }
            if(deck.getDeck().get(i).getSuit().equals("Hearts")){
               if(deck.getDeck().get(i).getRank()==11){
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*50);
               }
            }
            if(count==0){
               deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2());
            }
         } 
      }
      else if(trump.equals("Spades")){
         for(int i=0;i<24;i++){
            if(deck.getDeck().get(i).getSuit().equals("Spades")){
               
               if(deck.getDeck().get(i).getRank()==11){
              
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*100);
               }
               else{

                  deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*10);
               }
            }
            if(deck.getDeck().get(i).getSuit().equals("Clubs")){
               if(deck.getDeck().get(i).getRank()==11){

                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*50);
               }
            }
            if(count==0){
               deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2());
            }
         }   
      }
      else{
         for(int i=0;i<24;i++){
            if(deck.getDeck().get(i).getSuit().equals("Clubs")){
               if(deck.getDeck().get(i).getRank()==11){
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*100);
               }
               else{
                  deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*10);
               }
            }
            if(deck.getDeck().get(i).getSuit().equals("Spades")){
               if(deck.getDeck().get(i).getRank()==11){
                     deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2()*50);
               }
            }
            if(count==0){
               deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2());
            }
         }
      }
      count++; 
      
      
      if(count%2==0){
         t1.setGoing(false);
         t2.setGoing(true);
      }
      else{
         t1.setGoing(true);
         t2.setGoing(false);
      }
      
   }
   //Method to assign points to proper team
   
   public void assignPoints(){
   
      if(t1.getGoing()){ 
         if(t1.getAlone()&&t1.getTricks()==5){
            t1.setTotalScore(t1.getTotalScore()+4);
            winnerS = "Team 1";
         }
         else if(t1.getTricks()==3||t1.getTricks()==4){
            t1.setTotalScore(t1.getTotalScore()+1);
            winnerS = "Team 1";
         }
         else if(t1.getTricks()==5){
            t1.setTotalScore(t1.getTotalScore()+2);
            winnerS = "Team 1";
         }
         else if(t1.getTricks()<3){
            t2.setTotalScore(t2.getTotalScore()+2);
            winnerS = "EUCHRED!\nTeam 2";
         }
      }
      
      else{
         if(t2.getAlone()&&t2.getTricks()==5){
            t2.setTotalScore(t2.getTotalScore()+4);
            winnerS = "Team 2";
         }
         else if(t2.getTricks()==3||t2.getTricks()==4){
            t2.setTotalScore(t2.getTotalScore()+1);
            winnerS = "Team 2";
         }
         else if(t2.getTricks()==5){
            t2.setTotalScore(t2.getTotalScore()+2);
            winnerS = "Team 2";
         }
         else if(t2.getTricks()<3){
            t1.setTotalScore(t1.getTotalScore()+2);
            winnerS = "EUCHRED\nTeam 1";
         }
      }
            
   }
   
   
   //Dealing Method
   public void deal(){
      t1.getP1().getHand().clear();
      t1.getP2().getHand().clear(); 
      t2.getP1().getHand().clear();
      t2.getP2().getHand().clear();

      deck.shuffleDeck();
      
      for(int i=0;i<5;i++){
         t1.getP1().getHand().add(deck.getDeck().get(i));
      }
      for(int i=5;i<10;i++){
         t1.getP2().getHand().add(deck.getDeck().get(i));
      }
      for(int i=10;i<15;i++){
         t2.getP1().getHand().add(deck.getDeck().get(i));
      }
      for(int i=15;i<20;i++){
         t2.getP2().getHand().add(deck.getDeck().get(i));
      }
      
      leftOver = deck.getDeck().get(20);
      setTrump(leftOver.getSuit());
      
      createRanks();
      
   }
   
   
   
   
   
   
   //Method to decide ther winner of each trick
   public void trickWinner(){    
      if(!t1.getAlone()){
         if((card1.getRank()>card3.getRank()&&card1.getRank()>card4.getRank())||(card2.getRank()>card3.getRank()&&card2.getRank()>card4.getRank())){
            t1.setTricks(t1.getTricks()+1);
            if(card1.getRank()>card2.getRank()){
               winner = 1;
            }
            else{
               winner = 2;
            }
         }
         else{
             t2.setTricks(t2.getTricks()+1);
             
             if(card3.getRank()>card4.getRank()){
               winner = 3;
             }
             else{
               winner = 4;
             } 
         }
      }
      else{
         if(card1.getRank()>card3.getRank()&&card1.getRank()>card4.getRank()){
            t1.setTricks(t1.getTricks()+1);
         }
         else{
             t2.setTricks(t2.getTricks()+1);
         }
      }
   }
   
   
  
  
   //Method to play the other player's hands
   public void fillCards(String suit){
      setSuitLead(suit);
      //Player 2
      for(int i=0;i<t1.getP2().getHand().size();i++){
         if(t1.getP2().getHand().get(i).getSuit().equals(suit)){
            card2 = t1.getP2().getHand().get(i);
            break;
         }       
      }
      if(card2==null){
         card2 = t1.getP2().getHand().get(0);
      }
      t1.getP2().getHand().remove(card2);
      
      
      //Player 3
      for(int i=0;i<t2.getP1().getHand().size();i++){
         if(t2.getP1().getHand().get(i).getSuit().equals(suit)){
            card3 = t2.getP1().getHand().get(i);
            break;
         }       
      }
      if(card3==null){
         card3 = t2.getP1().getHand().get(0);
      }
      t2.getP1().getHand().remove(card3);      
      //Player 4
      for(int i=0;i<t2.getP2().getHand().size();i++){
         if(t2.getP2().getHand().get(i).getSuit().equals(suit)){
            card4 = t2.getP2().getHand().get(i);
            break;
         }       
      }
      if(card4==null){
         card4 = t2.getP2().getHand().get(0);
      }
      t2.getP2().getHand().remove(card4);
   }



   public void resetRanks(){
      for(int i=0;i<24;i++){
         deck.getDeck().get(i).setRank(deck.getDeck().get(i).getRank2());
      }
   }
   
   public void setCardsNull(){
      card2 = null;
      card3 = null;
      card4 = null;
   }
   
   
   
   
   
   
   
   
   
   // --- Get and Set ---
   public int getTurn() {
   	return turn;
   }
   public void setTurn(int turn) {
   	this.turn = turn;
   }
   public Deck getDeck() {
   	return deck;
   }
   public void setDeck(Deck deck) {
   	this.deck = deck;
   }
   public Team getT1() {
   	return t1;
   }
   public void setT1(Team t1) {
   	this.t1 = t1;
   }
   public Team getT2() {
   	return t2;
   }
   public void setT2(Team t2) {
   	this.t2 = t2;
   }
   public void setCard1(Card card1){
      this.card1 = card1;
   }
   public Card getCard1(){
      return card1;
   }
   public String getSuitLead() {
   	return suitLead;
   }
   public void setSuitLead(String suitLead) {
   	this.suitLead = suitLead;
   }
   public String getTrump() {
   	return trump;
   }
   public void setTrump(String trump){
      this.trump = trump;  
   }
   public Card getCard2(){
      return card2;
   }
   public Card getCard3(){
      return card3;
   }
   public Card getCard4(){
      return card4;
   }
   
   public int getWinner(){
      return winner;
   }
   
   public void setWinner(int w){
      winner = w;
   }  
   
   //Set left over card to trump
   public void setLeftOver(Card leftOver) {
   	this.leftOver = leftOver;
   }
   public Card getLeftOver(){
         return leftOver;
   }
   
   public String getWinnerS(){
      return winnerS;
   } 
}