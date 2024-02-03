package Validate;

import Model.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateLogin {
    static ArrayList<Login> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static String validateLoginUsername() {
        while (true) {
            System.out.println("Nhập username");
            String username = scanner.nextLine();
            if (!checkExistingUsername(username)) {
                System.out.println("username không tồn tại");
            } else {
                return username;
            }
        }
    }

    public static String validateLoginPassword() {
        while (true) {
            System.out.println("Nhập password");
            String password = scanner.nextLine();

            return password;
        }
    }

    public static boolean checkExistingUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
