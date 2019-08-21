package casinoUtils;

import casinoData.CasinoExceptions;
import casinoData.Player;

import java.util.Scanner;

public class Utils {

    //Return true for yes and false for no
    public static boolean inYesNoAnswer(){
        char answer;
        Scanner in = new Scanner(System.in);
        while (true){
            answer = in.next().charAt(0);
            if(answer == 'y' || answer == 'Y')
                return true;
            else if(answer == 'n' || answer == 'N')
                return false;
            System.out.println("Please enter 'y' for yes or 'n' fo not");
        }
    }

    //return the bid
    public static int setBid(Player p1) throws CasinoExceptions.outOfMoney {
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

            System.out.println("I'm afraid you don't own that much");
        } while (true);

        p1.withdraw(bid);
        return bid;
    }

    public static void resultGame(int won, Player p1, int bid){
        if(won > 0){
            System.out.println("You won " + bid);
            p1.deposit(2*bid);
        }else if(won == 0){
            System.out.println("It's a Tie");
            p1.deposit(bid);
        }else{
            System.out.println("Sorry, better luck next time");
        }
    }

    public static boolean keepPlaying(Player p){
        boolean keepPlay;
        if ( p.getBalance() <= 0){
            System.out.println("You're out of money");
            keepPlay = false;
        }else{
            System.out.println("Would you like to keep playing?");
            keepPlay = Utils.inYesNoAnswer();
        }
        return keepPlay;
    }

    //TODO : scanInt - safe scan for a case of getting string
}
