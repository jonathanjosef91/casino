package casinoData;

public class CasinoExceptions {
    public static class outOfMoney extends Exception{
        @Override
        public String getMessage() {
            return "Out of money";
        }
    }
    public static class yesOrNo extends Exception{
        @Override
        public String getMessage() {
            return "Please enter y or n";
        }
    }
}
