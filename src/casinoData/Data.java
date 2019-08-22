package casinoData;

import java.io.*;
import java.util.Scanner;

//TODO: when a  player registers check if pass or user name has ','
public class Data {

    public static void save(Player p) throws IOException {
        String path =  new File("."). getCanonicalPath() +"\\users\\" + p.getUserName()+".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path,false));
        writer.write(p.getPassword());
        writer.newLine();
        writer.write(p.getName());
        writer.newLine();
        writer.write(String.valueOf(p.getBalance()));

        writer.close();
    }

    public static Player load(String userName) throws IOException{
        String path =  new File("."). getCanonicalPath() +"\\users\\" +userName+".txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String password = reader.readLine();
        String name = reader.readLine();
        int balance = Integer.parseInt(reader.readLine());

        return new Player(name, balance, userName, password);
    }

    public static Player openGame() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Are you registered?(y/n)");
        String answer = in.next();
        if (answer.equals("y")){
            System.out.println("Enter user name:");
            String  user = in.next();
            System.out.println("Enter password:");
            String pass = in.next();
           return Login.logIn(user,pass);
        }
        else {
            return load(Registraition.register());
        }
    }
}
