package casinoData;

import card.*;

public class Player {
    private String name;
    private int balance;
    private static String defaultName = "AI";
    private static int defaultBalance = 5000;
    private String userName;
    private String password;

    public Hand hand;

    //C'tors
    public Player(String name,int balance,String userName,String pass){
        this.password = pass;
        this.userName = userName;
        this.name = name;
        this.balance = balance;
    }
    public Player(int balance,String userName,String pass){
        this(defaultName,balance,userName,pass);
    }
    public Player(String name,String userName,String pass){
        this(name,defaultBalance,userName,pass);
    }
    public Player(String userName,String pass){
        this(defaultName,defaultBalance,userName,pass);
    }

    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }

    public void withdraw(int bid) throws CasinoExceptions.outOfMoney{
        if( balance < bid)
            throw new CasinoExceptions.outOfMoney();
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
