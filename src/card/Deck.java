package card;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> cards;
    private Iterator<Card> deckIterator;

    //C'tors
    public Deck() throws Exception{
        this(1, Card.highestValue);
    }
    public Deck(int minValue) throws  Exception{
        this(minValue, Card.highestValue);
    }
    public Deck(int minValue, int maxValue) throws Exception{
        cards = new LinkedList<Card>();
        for (int i = minValue; i <= maxValue; i++)
            for (int j = 0; j < CardType.cardTypes.length; j++){
                cards.add(new Card(i, j));
            }

        deckIterator = cards.iterator();
    }

    //Public Methods
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public boolean hasNext(){
        return deckIterator.hasNext();
    }
    public int cardsLeft(){
        Iterator<Card> i = deckIterator;
        int counter = 0;
        while(i.hasNext())
            counter++;
        return counter;
    }
    public Card getNextCard() throws CardException.endOfDeck{
        if (deckIterator.hasNext())
            return deckIterator.next();
        else
            throw new CardException.endOfDeck();
    }
    public void print(){
        for(Iterator<Card> i = cards.iterator(); i.hasNext(); i.next().print());
    }
}
