package casinoData;

public class CasinoExceptions {
    public static class outOfMoney extends Exception{
        @Override
        public String getMessage() {
            return "Out of money";
        }
    }
}
