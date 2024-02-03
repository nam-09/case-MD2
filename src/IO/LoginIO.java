package IO;

import Model.Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginIO {
    static File file = new File("login.txt");
    public static void writerLogin(List<Login> accounts){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Login a : accounts) {
                bufferedWriter.write(a.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Login> readLogin() {
        ArrayList<Login> accounts = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
            String str = "";
            while ((str = bufferedReader.readLine()) !=null) {
                String[] arr = str.split(",");
                Login account = new Login(
                        Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);
                accounts.add(account);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}