package Card;

import java.util.Arrays;

public class Hand {
    private Card cards[];
    private int handIterator;

    public int length;

    //C'tor
    public Hand(){
        this(5);
    }
    public Hand(int maxHand){
        length = maxHand;
        cards = new Card[length];
        handIterator = 0;
    }

    //Public Methods
    public void setCard(Card c) throws Exception {
        if(c == null)
            throw new NullPointerException();
        if(handIterator >= cards.length)
            throw new CardException.fullHand();
        cards[handIterator++] = c;
    }
    public void fillHand(Deck d) throws Exception{
        if (d==null)
            throw new NullPointerException();

        while(handIterator < cards.length)
            setCard(d.getNextCard());

        getFirst();
        this.sort();
    }
    public boolean hasNext(){
        return (length-handIterator) > 0;
    }
    public Card getNextCard() throws Exception{
        return getCard(handIterator++);
    }
    public Card getCard(int i) throws Exception{
        if(i<0 || i>=cards.length)
            throw new CardException.badInput();

        if(cards[i] != null)
            return cards[i];
        throw new CardException.emptyCollection();
    }
    public void print(){
        for(Card c:cards)
            c.print();
    }
    public Card getFirst(){
        handIterator = 0;
        return cards[handIterator];
    }

    private void sort(){
        Arrays.sort(cards);
    }
}
