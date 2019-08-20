import casinoData.Player;

public class mainClass {
    public static void main(String args[]){
        try{
            playBlackJack(new Player());
        }catch(Exception e){
            System.out.println(e.getMessage());
        };
    }
}
