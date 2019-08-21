package games.blackJack;

import java.util.Scanner;  // Import the Scanner class
import casinoData.*;
import card.Card;
import card.Deck;
import card.Hand;
import casinoUtils.*;

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
        char charInput;
        boolean answer;
        Hand AIhand;
        System.out.println("Hi "+ p1.getName() + "! Welcome to the Black Jack table");

        //Every iterate represent a game.
        do {
            bid = Utils.setBid(p1);

            //Set game
            Deck deck = new Deck();
            deck.shuffle();
            p1.hand = new Hand();
            p1.hand.setCards(deck,Const.START_HAND);
            AIhand = new Hand();
            AIhand.setCards(deck,Const.START_HAND);

            //Start Play
            System.out.println("Dealer first card: ");
            AIhand.getFirst().print();

            //Next loop - Player get cards
            do{
                System.out.println("Your hand:");
                p1.hand.print();
                System.out.println("Hand Value: " + getHandValue(p1.hand));
                if(getHandValue(p1.hand) > Const.BLACK_JACK){
                    System.out.println("Im sorry, you're out!");
                    break;
                }

                System.out.println("Would you like to take another Card?");
                if (!Utils.inYesNoAnswer())
                    break;

                 p1.hand.setCard(deck.getNextCard());
            }while (true);    //End of "Player get cards"

            if(getHandValue(p1.hand) > Const.BLACK_JACK){
                Utils.resultGame(-1,p1,bid);
                continue;
            }

            //Next loop - Dealer get cards
            while(getHandValue(p1.hand) > 0 && getHandValue(AIhand) < Const.AI_DRAW){
                System.out.println("Dealer draw one");
                AIhand.setCard(deck.getNextCard());
            }
            if(getHandValue(AIhand) > Const.BLACK_JACK){
                System.out.println("Dealer is out!");
                Utils.resultGame(1,p1,bid);
                continue;
            }

            //Game Result
            System.out.println("Your hand:");
            p1.hand.print();
            System.out.println("Hand Value: " + getHandValue(p1.hand));
            System.out.println("Dealer's hand:");
            AIhand.print();
            System.out.println("Hand Value: " + getHandValue(AIhand));

            Utils.resultGame(getHandValue(p1.hand) - getHandValue(AIhand),p1, bid);

        }while (Utils.keepPlaying(p1));

        System.out.println("Bye! hope too see you soon");
    }

    private static int getHandValue(Hand h) throws Exception{
        int counter = 0;
        int numberOfAces = 0;
        Card c;
        h.getFirst();
        while (h.hasNext())
        {
            c = h.getNextCard();
            if (c.getValue() == 1) {
                counter += Const.HIGH_ACE;
                numberOfAces++;
            }else{
                counter += Math.min(c.getValue(), Const.ROYAL_VALUE);
            }
        }
        while (numberOfAces-- > 0)
            if (counter > Const.BLACK_JACK)
                counter += (Const.LOW_ACE - Const.HIGH_ACE);

        return counter;
    }

    //Assuming non of the players got knock out
    private static int checkHands(Hand h1, Hand h2) throws Exception{
        return getHandValue(h1) - getHandValue(h2);
    }
}
