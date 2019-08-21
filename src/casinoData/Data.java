package casinoData;

import java.io.*;
import java.util.Scanner;

//TODO: when a  player registers check if pass or user name has ','
public class Data {
    /*public static Player logIn(String user,String pass)throws Exception {
        try {
            FileReader r = new FileReader("..\\..\\resources\\playersData.txt");
            BufferedReader reader = new BufferedReader(r);
            Scanner in = new Scanner(System.in);
            String line;
            line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                if (split[0].equals(user)) {
                    if (split[1].equals(pass)) {
                        String[] playerData = reader.readLine().split(",");

                        return new Player(playerData[0], Integer.parseInt(playerData[1]), user, pass);
                    } else {
                        int counter = 3;
                        while (counter > 0) {
                            System.out.println("Password incorrect\n You have " + counter +
                                    "tries left\n Please Enter Password again\n");
                            String newPass = in.nextLine();
                            if (newPass.equals(split[1])) {
                                String[] playerData = reader.readLine().split(",");
                                return new Player(playerData[0], Integer.parseInt(playerData[1]), user, pass);
                            }
                            counter -= 1;
                        }
                        if (counter == 0)
                            System.out.println("Your user have been blocked\n");
                        return null;//FIXME: change to exception and catch immediately
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }

   /* public static Player logIn(String userName, String password) throws FileNotFoundException {
        /*File file = new File("..\\..\\resources\\playersData.txt");
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
    }*/

    public static void save(Player p) throws IOException {
        String path =  new File("."). getCanonicalPath() +"\\users\\" + p.getUserName()+".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path,false));
        writer.write(p.getPassword());
        writer.newLine();
        writer.write(p.getName());
        writer.newLine();
        writer.write(p.getBalance());

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
}
