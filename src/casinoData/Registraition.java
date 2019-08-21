package casinoData;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Registraition {
    public static void register() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello and welcome to our Casino\n Please enter user name:\n");
        String userName = in.next();
        String path =  new File("."). getCanonicalPath() +"\\users";
        while(!new File(path + "\\" + userName +".txt").exists()){
            System.out.println("User name "+ userName + "already exists\nPlease enter different user name");
            userName = in.next();
        }
        System.out.println("Please enter your password:\n");
        String password = in.next();
        System.out.println("Please enter your name:\n");
        String name = in.nextLine();
        Data.save(new Player(name,userName,password));
    }

}
