package Login;

import Model.Login;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginManager {


    List<Login> logins = new ArrayList<>();

    public void registerStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Staff Registration");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        Login login = new Login();
        login.setTeacherUsernames(username);
        login.setTeacherPasswords(password);
        logins.add(login);
        System.out.println("Registration successful");
    }

    public boolean StaffLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Staff Login");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        for (Login login : logins) {
            if (username.equals(login.getTeacherUsernames()) && password.equals(login.getTeacherPasswords())) {
                System.out.println("Login successful");
                return true;

            }
        }
        System.out.println("Invalid credentials. Please try again");
        return false;
    }




}
