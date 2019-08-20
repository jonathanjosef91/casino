package Card;

public class CardType {
    public static String cardTypes[] = {"Club","Diamond","Heart","Spade"};
    private int type;
    CardType(String type) throws Exception {
        //Check if type is legal
        for(int i = 0; i < cardTypes.length; i++)
            if(type == cardTypes[i]){
                this.type = i;
                return;
            }
        throw new CardException.badInput();
    }
    CardType(int type) throws Exception {
        if (0<=type && type < cardTypes.length)
            this.type = type;
        else
            throw  new CardException.badInput();
    }

    public int getType(){
        return type;
    }
}