import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;


public class EuchreDemo extends Application{
   
   private Label turn,porp,trump, tricks,score;
   private int portCount;
   private boolean gameover = true,first = true;
   private String name;
   private TextField text1;
   private static Stage stage2;
   private Scene scene2;
   private GridPane window;
   private HBox cards,buttons,sub;
   private Button card1, card2, card3, card4, card5, pickup, pass, card1Played,card2Played,card3Played,card4Played,going;
   
   //P1 is null because it waits for the player to enter their name in the text field.
   Player p1 = new Player(null);
   Player p2 = new Player("Player 2");
   Player p3 = new Player("Player 3");
   Player p4 = new Player("Player 4");
   Team t1 = new Team(p1,p2);
   Team t2 = new Team(p3,p4);
   Deck deck = new Deck();
   Table table = new Table(t1,t2,deck);
   
   @Override
   public void start(Stage stage){
      
      // ------ Welcome window ------
      
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(20,20,20,20));
      pane.setHgap(5);
      pane.setVgap(5);
      pane.setStyle("-fx-background-color:#1a8cff");
      
      Label label1 = new Label("Name:");
      
      text1 = new TextField();
      text1.setPromptText("Enter your name");
      
      Button enter = new Button("Enter");
      enter.setStyle("-fx-background-color:#42f49e");
      enter.setOnAction(this::enterButtonPressed);      
      
      //Add the elements to the grid    
      pane.add(label1,0,0);
      pane.add(text1,1,0);
      pane.add(enter,1,2);
      
      Scene s = new Scene(pane);
      stage.setTitle("Welcome");    
      stage.setResizable(false);
      stage.setScene(s);
      stage.show();

      stage2 = new Stage();
        
      GridPane pane2 = new GridPane();
      pane2.setPadding(new Insets(15,15,15,15));
      pane2.setStyle("-fx-background-color:#1a8cff");
      pane2.setVgap(10);   
   
       // ----- Game Window ----
   
      window = new GridPane();
      window.setPadding(new Insets(10,10,10,10));
      window.setStyle("-fx-background-color:#42f49e");
      window.setHgap(30);
      window.setAlignment(Pos.CENTER);
      
      card1Played = new Button();
      card1Played.setPrefSize(76,100);
      card1Played.setStyle("-fx-background-color:#2892b0");
      card1Played.setTextFill(Color.web("ffffff"));
      
      card2Played = new Button();
      card2Played.setPrefSize(76,100);
      card2Played.setStyle("-fx-background-color:#2892b0");
      card2Played.setTextFill(Color.web("ffffff"));
      
      card3Played = new Button();
      card3Played.setPrefSize(76,100);
      card3Played.setStyle("-fx-background-color:#2892b0");
      card3Played.setTextFill(Color.web("ffffff"));
      
      card4Played = new Button();
      card4Played.setPrefSize(76,100);
      card4Played.setStyle("-fx-background-color:#2892b0");
      card4Played.setTextFill(Color.web("ffffff"));

      turn = new Label("Waiting...");
      turn.setStyle("-fx-background-color:#42f49e");
      turn.setTextFill(Color.web("#0843AD"));
      turn.setFont(new Font("Cambria", 16));
      
      trump = new Label("-Trump-\n");
      trump.setStyle("-fx-background-color:#42f49e");
      trump.setTextFill(Color.web("#0843AD"));
      trump.setFont(new Font("Cambria", 16));
      
      tricks = new Label("-Tricks-\nTeam I : " + table.getT1().getTricks()+"\nTeam II: "+table.getT2().getTricks());
      tricks.setStyle("-fx-background-color:#42f49e");
      tricks.setTextFill(Color.web("#0843AD"));
      tricks.setFont(new Font("Cambria", 16));
      
      score = new Label("-Score-\nTeam I : " + table.getT1().getTotalScore()+"\nTeam II: "+table.getT2().getTotalScore());
      score.setStyle("-fx-background-color:#42f49e");
      score.setTextFill(Color.web("#0843AD"));
      score.setFont(new Font("Cambria", 16));
      
      window.add(score,0,2);
      window.add(card3Played,0,1);
      window.add(card2Played,1,0);
      window.add(card4Played,2,1);
      window.add(card1Played,1,2);
      window.add(turn,1,1);
      window.add(trump,2,0);
      window.add(tricks,2,2);
      window.setPrefSize(400,320);
      pane2.add(window,0,0);
      // ---- Game window ends ----
      
      // ------ Menu Buttons -------  
      buttons = new HBox(5);
      buttons.setStyle("-fx-background-color:#1a8cff");
      buttons.setPrefSize(400,30);
      pane2.add(buttons,0,1);
      
      going = new Button("Go Alone");
      going.setOnAction(this::goingBtnPressed);
      pass = new Button("Start Game");
      pass.setOnAction(this::passBtnPressed);
      pass.setPrefSize(200,30);
      going.setPrefSize(200,30);
      buttons.getChildren().addAll(going,pass);
      
      // ---- Menu Buttons end ---- 
      
      // ------ Card Buttons ------ 
      cards = new HBox(5);
      cards.setStyle("-fx-background-color:#1a8cff");
      
      card1 = new Button("Card1");
      card1.setPrefSize(76,120);
      card1.setOnAction(this::card1BtnPressed);
   
      card2 = new Button("Card2");
      card2.setPrefSize(76,120);
      card2.setOnAction(this::card2BtnPressed);
      
      card3 = new Button("Card3");
      card3.setPrefSize(76,120);
      card3.setOnAction(this::card3BtnPressed);
      
      card4 = new Button("Card4");
      card4.setPrefSize(76,120);
      card4.setOnAction(this::card4BtnPressed);
      
      card5 = new Button("Card5"); 
      card5.setPrefSize(76,120);
      card5.setOnAction(this::card5BtnPressed);
      
      cards.getChildren().addAll(card1,card2,card3,card4,card5);
    
      cards.setPrefSize(400,120);
      pane2.add(cards,0,2);
         
      scene2 = new Scene(pane2,400,500);
      stage2.setScene(scene2);
      stage2.setResizable(false);
      }

   // BUTTON METHODS START   
   public void enterButtonPressed(ActionEvent e){
      name = text1.getText();
      p1.setName(text1.getText());
      stage2.setTitle("Player: " + name);
      stage2.show();
      turn.setText("Welcome\nto\nEuchre!");
   }
   
   public void card1BtnPressed(ActionEvent e){
      if(!card1.getText().equals("Played")&&!card1.getText().equals("")&& !gameover){
         card1Played.setText(p1.getHand().get(0).toString());
         card1.setText("Played");
         fillCards(table.getT1().getP1().getHand().get(0).getSuit());
         table.getT1().getP1().setCardPlayed(p1.getHand().get(0));
         table.setCard1(table.getT1().getP1().getHand().get(0));
         table.trickWinner();
         printTricks();
         table.setCardsNull();
         finish();
      }
   }
   
   public void card2BtnPressed(ActionEvent e){
      if(!card2.getText().equals("Played")&&!card2.getText().equals("")&& !gameover){
         card1Played.setText(p1.getHand().get(1).toString());
         card2.setText("Played");
         fillCards(table.getT1().getP1().getHand().get(1).getSuit());
         table.getT1().getP1().setCardPlayed(p1.getHand().get(1));
         table.setCard1(table.getT1().getP1().getHand().get(1));
         table.trickWinner();
         printTricks();
         table.setCardsNull();
         finish();
      }
   }
   
   public void card3BtnPressed(ActionEvent e){
      if(!card3.getText().equals("Played")&&!card3.getText().equals("")&& !gameover){
         card1Played.setText(p1.getHand().get(2).toString());
         card3.setText("Played");
         fillCards(table.getT1().getP1().getHand().get(2).getSuit());
         table.getT1().getP1().setCardPlayed(p1.getHand().get(2));
         table.setCard1(table.getT1().getP1().getHand().get(2));
         table.trickWinner();
         printTricks();
         table.setCardsNull();
         finish();
      }
   }
   
   public void card4BtnPressed(ActionEvent e){
      if(!card4.getText().equals("Played")&&!card4.getText().equals("")&& !gameover){
         card1Played.setText(p1.getHand().get(3).toString());
         card4.setText("Played");
         fillCards(table.getT1().getP1().getHand().get(3).getSuit());
         table.getT1().getP1().setCardPlayed(p1.getHand().get(3)); 
         table.setCard1(table.getT1().getP1().getHand().get(3));
         table.trickWinner();
         printTricks();
         table.setCardsNull();
         finish();
      }
   }
   
   public void card5BtnPressed(ActionEvent e){
      if(!card5.getText().equals("Played")&&!card5.getText().equals("")&& !gameover){
         card1Played.setText(p1.getHand().get(4).toString());
         card5.setText("Played");
         fillCards(table.getT1().getP1().getHand().get(4).getSuit());
         table.getT1().getP1().setCardPlayed(p1.getHand().get(4)); 
         table.setCard1(table.getT1().getP1().getHand().get(4));
         table.trickWinner();
         printTricks();
         table.setCardsNull();
         finish();
      }
   }

   public void passBtnPressed(ActionEvent e){
      if((table.getT1().getTricks()+table.getT2().getTricks()==0 && !gameover) || first){
         if(first){
            pass.setText("Next Hand");
         }
         first = false;
         gameover = false;
         card1Played.setText("");
         card2Played.setText("");
         card3Played.setText("");
         card4Played.setText("");
         going.setStyle(null);
         table.getT1().setAlone(false);
         // reset everything
         populate();
         turn.setText("Play\nyour\ncard!");
         
      }   
   }
   
   public void goingBtnPressed(ActionEvent e){
      if(table.getT1().getTricks() + table.getT2().getTricks() == 0 && !gameover){
         table.getT1().setAlone(true);
         going.setStyle("-fx-background-color:RED");
      }
   } 
   //BUTTON METHODS END
   
   public void finish(){
      if(table.getT1().getTricks()+table.getT2().getTricks()==5){
         gameover();
         table.assignPoints();
         printScore();
         turn.setText(table.getWinnerS()+"\nWins!!");
         table.getT1().setTricks(0);
         table.getT2().setTricks(0);
      }
   }
   
   public void populate(){
      table.deal();
      card1.setText(p1.getHand().get(0).toString());
      card2.setText(p1.getHand().get(1).toString());
      card3.setText(p1.getHand().get(2).toString());
      card4.setText(p1.getHand().get(3).toString());
      card5.setText(p1.getHand().get(4).toString());
      setTrump(table.getTrump());
      printTricks();
      }

   public void setTrump(String s){
      trump.setText("-Trump-\n" + s);
   }
   public void gameover(){
      if(table.getT1().getTotalScore() ==10){
         turn.setText("TEAM1\nWINS!!");
         gameover = true;
      } 
      else if(table.getT2().getTotalScore() == 10){
         turn.setText("TEAM2\nWINS!!");
         gameover = true;
      }
   }

   public void fillCards(String s){
      table.fillCards(s);
      if(!table.getT1().getAlone()){
         card2Played.setText(table.getCard2().toString()); 
      }
      else{
         card2Played.setText("");
         table.getCard2().setRank(0);
      }
      card3Played.setText(table.getCard3().toString());
      card4Played.setText(table.getCard4().toString());
      if(!table.getCard2().getSuit().equals(table.getSuitLead())){
         if(table.getCard2().getSuit().equals(table.getTrump())||table.getCard2().getRank()==550){
         }
         else{
            table.getCard2().setRank(0);
         }
      }
      if(!table.getCard3().getSuit().equals(table.getSuitLead())){
         if(table.getCard3().getSuit().equals(table.getTrump())||table.getCard3().getRank()==550){
         }
         else{
            table.getCard3().setRank(0);
         }
      }
      if(!table.getCard4().getSuit().equals(table.getSuitLead())){
         if(table.getCard4().getSuit().equals(table.getTrump())||table.getCard4().getRank()==550){
         }
         else{
            table.getCard4().setRank(0);
         }
      }
   }
   
   public void cardPlayedClear(){
      card1Played.setText("");
      card2Played.setText("");
      card3Played.setText("");
      card4Played.setText("");
   }

   public void printTricks(){
      tricks.setText("-Tricks-\nTeam I : " + table.getT1().getTricks()+"\nTeam II: "+table.getT2().getTricks());
      turn.setText("Player " + table.getWinner() + "\nwins!");
   }
   
   public void printScore(){
      score.setText("-Score-\nTeam I : " + table.getT1().getTotalScore()+"\nTeam II: "+table.getT2().getTotalScore());
   }
   
   //MAIN METHOD
   public static void main(String[] args){
      Application.launch(args);
     }
}