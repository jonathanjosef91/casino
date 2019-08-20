import casinoData.Player;
import games.BlackJack;
import casinoData.*;

public class mainClass {
    public static void main(String args[]){
        try{
            BlackJack.playBlackJack(new Player());
        }catch(Exception e){
            System.out.println(e.getMessage());
        };
    }
}
