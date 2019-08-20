package card;

public class Card implements Comparable<Card>{
    public static int highestValue = 13;
    private int value;
    private CardType type;

    //C'tors
    public Card (int v, String t) throws Exception{
        if (v < 1 || v > highestValue)
            throw new CardException.badInput();
        value = v;
        type = new CardType(t);
    }
    //1<=v=<13 or throw Exception
    //every t will do, send (mod)numOfTypes
    public Card (int v, int t) throws Exception{
        this(v, CardType.cardTypes[t%CardType.cardTypes.length]);
    }

    //Public Methods
    public int getValue(){
        return value;
    }
    public String getType(){
        return CardType.cardTypes[type.getType()];
    }
    public void print() {
        String toPrint = "";
        switch (value) {
            case 1:
            case 14:
                toPrint += "A";
                break;
            case 11:
                toPrint += "J";
                break;
            case 12:
                toPrint += "Q";
                break;
            case 13:
                toPrint += "K";
                break;
            default:
                toPrint += value;
        }
        toPrint += (" of " + CardType.cardTypes[type.getType()]);
        System.out.println(toPrint);
    }


    public int compareTo(Card c) {
        return (this.type.getType() - c.type.getType())*(highestValue+1) + (this.value-c.value);
    }
}
