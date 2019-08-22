package casinoData;

import java.io.*;
import java.util.Scanner;

public class Login {
    public static Player logIn(String userName,String password) throws IOException {
        try{
            String path =  new File("."). getCanonicalPath() +"\\users\\" + userName + ".txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String pass = reader.readLine();
            Scanner in = new Scanner(System.in);
            if (pass.equals(password)){
                reader.close();
                return Data.load(userName);
            }
            int counter = 3;
            while (counter > 0){
                System.out.println("Password incorrect please try again\n You have " + counter + " tries left\n");
                String passTry = in.next();
                if(passTry.equals(pass)){
                    reader.close();
                    return Data.load(userName);
                }
                counter -= 1;
            }
            System.out.println("Sorry the user " + userName +" have been blocked for 30 sec"); //TODO: create a time stamp;
            reader.close();
        }
        catch (Exception e){
            System.out.println("you are not registered yet");
            Registraition.register();
        }
        return null;
    }

 }
