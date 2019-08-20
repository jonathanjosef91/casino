package games;

import java.rmi.activation.ActivationID;
import java.util.Scanner;  // Import the Scanner class
import casinoData.*;
import card.Card;
import card.Deck;
import card.Hand;


public class BlackJack {
    public static void playBlackJack(Player p1) throws Exception{
        //check if have money
        if(p1 == null)
            throw new NullPointerException();

        if(p1.getBalance() <= 0)
            throw new CasinoExceptions.outOfMoney();

        Scanner input = new Scanner(System.in);  // Create a Scanner object
        boolean keepPlay = true;
        int bid;
        char answer;

        System.out.println("Hi "+ p1.getName() + "! Welcome to the Black Jack table");

        do {
            bid = setBid(p1);

            //Set game
            Deck deck = new Deck();
            deck.shuffle();
            p1.hand = new Hand(2);
            p1.hand.fillHand(deck);

            //Start Play
            System.out.println("Your hand:");
            p1.hand.print();
            System.out.println("Hand Value: " + getHandValue(p1.hand));
            System.out.println("Would you like to take another Card? y/n");
            do{
                answer = input.next().charAt(0);
                if(checkYesNoAnswer(answer))
                    break;
                System.out.println("Please enter y or n");
            }while(true);

            System.out.println("Would you like to keep playing?");
        }while (keepPlay);

        System.out.println("Bye! hope too see you soon");
    }

    private static boolean checkYesNoAnswer(char answer){
        return (answer == 'y' || answer == 'Y' || answer == 'n' || answer == 'N');
    }
    private static boolean getCards(){
        return true;
    }

    private static int setBid(Player p1) {
        int bid;
        Scanner input = new Scanner(System.in);
        System.out.println("You have " + p1.getBalance() + "$.");
        System.out.println("How much money do you want to bet on?");
        do {
            bid = input.nextInt();
            if (bid <= 0) {
                System.out.println("Please enter a positive number");
                continue;
            }
            if (bid <= p1.getBalance())
                break;

            System.out.println("I'm afraid you dont own that much");
        } while (true);

        p1.deposit(bid);
        return bid;
    }


    private static int getHandValue(Hand h) throws Exception{
        int counter = 0;
        int numberOfAces = 0;
        Card c;
        while (h.hasNext())
        {
            c = h.getNextCard();
            if (c.getValue() == 1) {
                counter += BlackJackConst.Values.HIGH_ACE;
                numberOfAces++;
            }else if(c.getValue()>= BlackJackConst.Values.ROYAL_VALUE){
                counter+=BlackJackConst.Values.ROYAL_VALUE;
            }else{
                counter += c.getValue();
            }
        }
        while (numberOfAces-- > 0)
            if (counter > BlackJackConst.Values.BLACK_JACK)
                counter += (BlackJackConst.Values.LOW_ACE - BlackJackConst.Values.HIGH_ACE);

        return counter;
    }

}
