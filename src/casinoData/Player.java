package casinoData;

import card.*;

public class Player {
    private String name;
    private int balance;
    private static String defaultName = "AI";
    private static int defaultBalance = 5000;

    public Hand hand;

    //C'tors
    public Player(String name,int balance){
        this.name = name;
        this.balance = balance;
    }
    public Player(int balance){
        this(defaultName,balance);
    }
    public Player(String name){
        this(name,defaultBalance);
    }
    public Player(){
        this(defaultName,defaultBalance);
    }

    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }

    public void withdraw(int bid) throws Exception{
        if( balance < bid)
            throw new outOfMoney();
        balance -= bid;
    }
    public void deposit(int prize){
        balance += prize;
    }

    public static class outOfMoney extends Exception{
        @Override
        public String getMessage() {
            return "Bad Input";
        }
    }
}
