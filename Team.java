public class Team{
   
   private int totalScore = 0;
   private int tricks = 0;
   private boolean alone = false;
   private boolean going = false;
   private Player p1;
   private Player p2;
   
   //CONSTRCUTOR
   public Team(Player p1, Player p2){
      this.p1 = p1;
      this.p2 = p2;
   }
   // ---Get and Set Methods---
   public int getTotalScore(){
      return totalScore;
   }
   public Player getP1(){
      return p1;
   }
   public Player getP2(){
      return p2;
   }
   
   public void setP1(Player p1){
      this.p1 = p1;
   }
   
   public void setP2(Player p2){
      this.p2 = p2;
   }
   
   
   public int getTricks(){
      return tricks;
   }
   public boolean getAlone(){
      return alone;
   }
   public boolean getGoing(){
      return going;
   }
   public void setTotalScore(int totalScore){
      this.totalScore = totalScore;
   }
   public void setTricks(int tricks){
      this.tricks = tricks;
   }
   public void setAlone(boolean alone){
      this.alone = alone;
   }
   public void setGoing(boolean going){
      this.going = going;
   }
}