package card;
public class CardException {
    public static class badInput extends Exception{
        @Override
        public String getMessage() {
            return "Bad Input";
        }
    }
    public static class endOfDeck extends Exception{
        @Override
        public String getMessage() {
            return "End Of Deck";
        }
    }
    public static class fullHand extends Exception{
        @Override
        public String getMessage() {
            return "Hand is full";
        }
    }
    public static class emptyCollection extends Exception{
        @Override
        public String getMessage() {
            return "Empty collection";
        }
    }
}
