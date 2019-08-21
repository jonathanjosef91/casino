package casinoData;

import java.io.*;
import java.util.Scanner;

public class Login {
    public static Player logIn(String userName,String password) throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(userName));
            String pass = reader.readLine();
            Scanner in = new Scanner(System.in);
            if (pass.equals(password)){
                String name = reader.readLine();
                String balance = reader.readLine();
                reader.close();
                return new Player(name,Integer.parseInt(balance),userName,password);
            }
            int counter = 3;
            while (counter > 0){
                System.out.println("Password incorrect please try again\n You have " + counter + " tries left\n");
                String passTry = in.next();
                if(passTry.equals(password)){
                    String name = reader.readLine();
                    String balance = reader.readLine();
                    reader.close();
                    return new Player(name,Integer.parseInt(balance),userName,password);
                }
                counter -= 1;
            }
            System.out.println("Sorry the user " + userName +" have been blocked for 30 sec"); //TODO: create a time stamp;
            reader.close();
        }
        catch (Exception e){
            System.out.println("you are not registered yet");//TODO: send to registration
            Registraition.register();

        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("enter user name:\n");
        String user = in.next();
        System.out.println("enter pass:\n");
        String pass = in.next();
        logIn(user,pass);
    }

 }
