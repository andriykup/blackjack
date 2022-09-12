import java.util.Scanner;

public class Blackjack{

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        //Getting and printing two random cards for user.
        int randomCard1 = drawRandomCard();
        int randomCard2 = drawRandomCard();
        System.out.println("\n You get a \n" + cardString(randomCard1) + "\n and a \n" + cardString(randomCard2));


        //Printing sum of user hand value.
        if(randomCard1 > 10){
            randomCard1 = 10;
        }
        if(randomCard2 > 10){
            randomCard2 = 10;
        }
        int total = randomCard1 + randomCard2;
        System.out.println("your total is: " + total);
        

        //Geting and printing two random cards for dealer, second card is hidden.
        int firstCard = drawRandomCard();
        int secondCard = drawRandomCard();
        System.out.println("\n The dealer shows \n" + cardString(firstCard) + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

///need to separete while loop, user loop, dealer loop and afte both loops we can decide who win.
        while(true){
            System.out.println("\nWould you like to hit or stay?");
            String answer = hitOrStay(); //Assking player if he want hit or stay and below we will check gis answer.

            //If user want to "stay", then this is the Dealer turn.
            if(answer.equals("stay")){
                System.out.println("\nDealer's turn");

                //Lets show to user the boith dealer's cards.
                System.out.println("\nThe dealer's cards are\n" + cardString(firstCard) + "\n and a\n" + cardString(secondCard));
                
                if(firstCard > 10){
                    firstCard = 10;
                }
                if(secondCard > 10){
                    secondCard = 10;
                }
//counting total dealer's hand value and below check if dealer shoiuld hit or stay.
                int dealerTotal = firstCard + secondCard;
                System.out.println("\nDealer's total is: " + dealerTotal);
                while(dealerTotal <= 17){
                    int tempCard = drawRandomCard();
                    System.out.println("\nDealer gets a \n" + cardString(tempCard));
                    
                    if(tempCard > 10){
                        tempCard = 10;
                    }

                    dealerTotal += tempCard;
                    System.out.println("\nDealer's total is: " + dealerTotal);
                }

                //below lets decide who wins.
                if(dealerTotal > 21){
                    System.out.println("Bust! Dealer loses" );
                    System.exit(0);
                }
                if(total > dealerTotal){
                    System.out.println("Player wins!");
                    System.exit(0);
                }else{
                    System.out.println("Dealer wins!");
                    System.exit(0);
                }
            }

            //if user "hit", then next card will be drawn.
            int randomCardN = drawRandomCard();
            System.out.println("\n You get a \n" + cardString(randomCardN));

            if(randomCardN > 10){
                randomCardN = 10;
            }
            //updating user total hand value and print it.
            total += randomCardN; 
            System.out.println("your new total is: " + total);
            //if the user's total is higher then 21, the user loses.  
            if(total > 21){
                System.out.println("Bust! Player loses");
                System.exit(0);
                break;
            }
        }
        
        scan.close();        
    }

     //func returns a random number between 1 and 13
     public static int drawRandomCard(){
        double num = Math.random() * 13;
        num += 1;
        return (int)num;
    }

     //func returns a String drawing of the card.
     public static String cardString(int cardNumber){
        switch(cardNumber){
            case 1:return ( "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n");
            case 2:return ("   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n");
            case 3:return ("   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n");
            case 4:return ("   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n");
            case 5:return ("   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n");
            case 6:return ("   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n");
            case 7:return ("   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n");
            case 8:return ("   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n");
            case 9:return ("   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n");
            case 10:return ("   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n");
            case 11:return ("   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n");
            case 12:return ("   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n");
            case 13:return  ("   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n");
            default: return ("");
        }
     }

        public static String faceDown() {
            return
            "   _____\n"+
            "  |     |\n"+ 
            "  |  J  |\n"+
            "  | JJJ |\n"+
            "  |  J  |\n"+
            "  |_____|\n";
        }
    

        //func asks the user to hit or stay.
        public static String hitOrStay(){
            while(true){
                String answer = scan.nextLine();
                if(!answer.equals("stay") && !answer.equals("hit")){
                    System.out.println("Please write 'hit' or 'stay'");
                    continue;
                }
                if(answer.equals("stay")){
                    return "stay";
                }
                if(answer.equals("hit")){
                    return "hit";
                }
                
            }
        }

}

