package casinoData;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Registraition {
    public static String register() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello and welcome to our Casino\nPlease enter user name:");
        String userName = in.next();
        String path =  new File("."). getCanonicalPath() +"\\users";
        while(new File(path + "\\" + userName +".txt").exists()){
            System.out.println("User name "+ userName + " already exists\nPlease enter different user name");
            userName = in.next();
        }
        System.out.println("Please enter your password:");
        String password = in.next();
        System.out.println("Please enter your name:");
        String name = in.next();
        Data.save(new Player(name,userName,password));
        return userName;
    }

}
