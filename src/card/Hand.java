package card;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Hand {
    private LinkedList<Card> cards;
    private Iterator<Card> handIterator;
    private boolean hasMax;
    private int maxHand;

    //C'tor
    public Hand(){
        this(0);
    }
    public Hand(int maxHand){
        cards = new LinkedList<Card>();
        this.maxHand = maxHand;
        this.hasMax = maxHand > 0;
        handIterator = cards.iterator();
    }

    //Public Methods
    public void setCard(Card c) throws Exception {
        if(c == null)
            throw new NullPointerException();
        if( hasMax && maxHand <= cards.size())
            throw new CardException.fullHand();
        cards.add(c);
    }
    public void setCards(Deck d, int numberOfCards) throws Exception{
        for(int i = 0; i < numberOfCards ; i++)
            setCard(d.getNextCard());
    }
    public void fillHand(Deck d) throws Exception{
        if (d==null)
            throw new NullPointerException();
        if (!hasMax)
            throw new CardException.handHasntMax();

        while(cards.size() < maxHand)
            setCard(d.getNextCard());

        this.getFirst();
        this.sort();
    }
    public boolean hasNext(){
        return handIterator.hasNext();
    }
    public Card getNextCard() throws Exception{
        return handIterator.next();
    }
    public Card getCard(int i) throws Exception{
        if(i<0 || i>=cards.size())
            throw new CardException.badInput();
        return cards.get(i);
    }
    public void print(){
        for(Iterator<Card> i = cards.iterator(); i.hasNext(); i.next().print());
    }
    public Card getFirst(){
        handIterator = cards.iterator();
        return cards.getFirst();
    }
    private void sort(){
        Collections.sort(cards);
    }
}
