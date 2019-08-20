package games;

import casinoData.*;
import card.Card;
import card.Deck;
import card.Hand;


public class BlackJack {
    public static void playBlackJack(Player p1) throws Exception{
        System.out.println("Hi "+ p1.getName() + "! Welcome to the Black Jack table");
        boolean keepPlay = true;
        do {
            System.out.println("You have "+ p1.getBalance() + "$.");
            System.out.println("How much money do you want to bet on?");
            Deck deck = new Deck();
            deck.shuffle();
            p1.hand = new Hand(2);
            p1.hand.fillHand(deck);

            System.out.println("1st casinoData.Player Hand:");
            p1.hand.print();
            System.out.println("Hand Value: " + getHandValue(p1.hand));
            System.out.println("Would you like to take another Card?");

            System.out.println("Would you like to keep playing?");
        }while (keepPlay);
    }

    public boolean getCards(){

    }
    public static int getHandValue(Hand h) throws Exception{
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
