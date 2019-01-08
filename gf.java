public void setTheTrump(int turn){ //we take in the turn that we must monitor throughout the game.
      int count=0; //if the count is more than or equal to 4, than means everyone has passed and anyone can set trump.
      boolean pass= false;
      while(pass=false){
         System.out.print(deck.getDeck().get(21));
         if(turn ==1 && count<4){
            System.out.print("To pickup type 0,to pass type 1.");
            int pickupPass= kb.nextInt();
            if(pickupPass == 0){
               System.out.print("Enter which card you wish to replace");
               int remove= kb.nextInt();
               t1.getP1().getHand().remove(remove);
               t1.getP1().getHand().add(deck.getDeck().get(21));
               pass=true;
            }
            turn++;
            count++;
         }
         else if(turn ==2 && count<4){
            System.out.print("To pickup type 0,to pass type 1.");
            int pickupPass= kb.nextInt();
            if(pickupPass == 0){
               System.out.print("Enter which card you wish to replace");
               int remove= kb.nextInt();
               t2.getP1().getHand().remove(remove);
               t2.getP1().getHand().add(deck.getDeck().get(21));
               pass=true;
            }
            turn++;
            count++;
         }
         else if(turn ==3 && count<4){
            System.out.print("To pickup type 0,to pass type 1.");
            int pickupPass= kb.nextInt();
            if(pickupPass == 0){
               System.out.print("Enter which card you wish to replace");
               int remove= kb.nextInt();
               t1.getP2().getHand().remove(remove);
               t1.getP2().getHand().add(deck.getDeck().get(21));
               pass=true;
            }
            turn++;
            count++;
         }
         else if(turn ==4&& count<4){
            System.out.print("To pickup type 0,to pass type 1.");
            int pickupPass= kb.nextInt();
            if(pickupPass == 0){
               System.out.print("Enter which card you wish to replace");
               int remove= kb.nextInt();
               t2.getP2().getHand().remove(remove);
               t2.getP2().getHand().add(deck.getDeck().get(21));
               pass=true;
            }
            count++;
            turn=1; //resets the turn back to the start
         }
         else if(turn ==1&& count != 7){
            System.out.print("Type 0 to pass, or set trump by typing 1 for Hearts, 2 for Diamonds, 3 for Spades and 4 for Clubs.") ; 
            int pickupPass= kb.nextInt();
            if(pickupPass==1){
               setTrump("Hearts");
               pass=true;
            }
            else if(pickupPass ==2){
               setTrump("Diamonds");
               pass=true;
            }
            else if(pickupPass ==3){
               setTrump("Spades");
               pass=true;
            }
            else if(pickupPass ==4){
               setTrump("Clubs");
               pass=true;
            }
            else if(pickupPass ==0){System.out.print("Passed");}
            else{System.out.print("Incorrect entry");}
            count++;
            turn++;
         }
         else if(turn ==2&& count != 7){
            System.out.print("Type 0 to pass, or set trump by typing 1 for Hearts, 2 for Diamonds, 3 for Spades and 4 for Clubs.") ; 
            int pickupPass= kb.nextInt();
            if(pickupPass==1){
               setTrump("Hearts");
               pass=true;
            }
            else if(pickupPass ==2){
               setTrump("Diamonds");
               pass=true;
            }
            else if(pickupPass ==3){
               setTrump("Spades");
               pass=true;
            }
            else if(pickupPass ==4){
               setTrump("Clubs");
               pass=true;
            }
            else if(pickupPass ==0){System.out.print("Passed");}
            else{System.out.print("Incorrect entry");}
            count++;
            turn++;
         }
         else if(turn ==3&& count != 7){
            System.out.print("Type 0 to pass, or set trump by typing 1 for Hearts, 2 for Diamonds, 3 for Spades and 4 for Clubs.") ; 
            int pickupPass= kb.nextInt();
            if(pickupPass==1){
               setTrump("Hearts");
               pass=true;
            }
            else if(pickupPass ==2){
               setTrump("Diamonds");
               pass=true;
            }
            else if(pickupPass ==3){
               setTrump("Spades");
               pass=true;
            }
            else if(pickupPass ==4){
               setTrump("Clubs");
               pass=true;
            }
            else if(pickupPass ==0){System.out.print("Passed");}
            else{System.out.print("Incorrect entry");}
            count++;
            turn++;
         }
         else if(turn ==4&& count != 7){
            System.out.print("Type 0 to pass, or set trump by typing 1 for Hearts, 2 for Diamonds, 3 for Spades and 4 for Clubs.") ; 
            int pickupPass= kb.nextInt();
            if(pickupPass==1){
               setTrump("Hearts");
               pass=true;
            }
            else if(pickupPass ==2){
               setTrump("Diamonds");
               pass=true;
            }
            else if(pickupPass ==3){
               setTrump("Spades");
               pass=true;
            }
            else if(pickupPass ==4){
               setTrump("Clubs");
               pass=true;
            }
            else if(pickupPass ==0){System.out.print("Passed");}
            else{System.out.print("Incorrect entry");}
            count++;
            turn=1;
         }
         //Sticking it to the dealer. If no one calls trump, dealer MUST set trump.
         else if(turn ==1&& count == 7){
            //Type in trump
            String set= kb.next();
            setTrump(set);
         }
         else if(turn ==2&& count == 7){
            //Type in trump
            String set= kb.next();
            setTrump(set);
         }
         else if(turn ==3&& count == 7){
            //Type in trump
            String set= kb.next();
            setTrump(set);
         }
         else if(turn ==4&& count == 7){
            //Type in trump
            String set= kb.next();
            setTrump(set);
         }
      }
   }
