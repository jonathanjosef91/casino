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
    public static int setBid(Player p1) {
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
}
