package casinoData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//TODO: when a  player registers check if pass or user name has ','
public class Data {
    public static Player logIn(String userName, String password) throws FileNotFoundException {
        File file = new File("..\\..\\resources\\playersData.txt");
        Scanner sc = new Scanner(file);
        Scanner in = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");

            if (line[0].equals(userName)) {
                if (line[1].equals(password)) {
                    String[] playerData = sc.nextLine().split(",");
                    return new Player(playerData[0], Integer.parseInt(playerData[1]), userName, password);
                } else {
                    int counter = 3;
                    while (counter > 0) {
                        System.out.println("Password incorrect\n You have " + counter +
                                "tries left\n Please Enter Password again\n");
                        String newPass = in.nextLine();
                        if (newPass.equals(line[1])) {
                            String[] playerData = sc.nextLine().split(",");
                            return new Player(playerData[0], Integer.parseInt(playerData[1]), userName, password);
                        }
                        counter -= 1;
                    }
                    if (counter == 0)
                        System.out.println("Your user have been blocked\n");
                    return null;//FIXME: change to exception and catch immediately
                }
            }
        }
        return null;
    }
}
