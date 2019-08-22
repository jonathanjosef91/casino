import casinoData.Data;
import casinoData.Player;
import games.BlackJack.BlackJack;

public class mainClass {
    public static void main(String args[]){
        try{
            games.BlackJack.BlackJack.playBlackJack(Data.openGame());
        }catch(Exception e){
            System.out.println(e.getMessage());
        };
    }
}
