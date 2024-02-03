package Menu;

import Model.Person;
import Model.Room;
import Manager.Hotel;
import Manager.RoomA;
import Manager.RoomB;
import Manager.RoomC;
import Login.LoginManager;

import java.util.Scanner;

public class Menu {
public static void menu() {
    Scanner scanner = new Scanner(System.in);
    Hotel hotel = new Hotel();
    LoginManager loginManager = new LoginManager();
    boolean isLoggedIn = false;

    while (true) {
        if (!isLoggedIn) {
            System.out.println("Enter 1: Đăng ký");
            System.out.println("Enter 2: Đăng nhập");
            System.out.println("Enter 3: Thoát");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    loginManager.registerStaff();
                    break;
                case "2":
                    if (loginManager.StaffLogin()) {
                        isLoggedIn = true;
                        System.out.println("Đăng nhập thành công. Chào mừng đến với hệ thống quản lý khách sạn!");
                    } else {
                        System.out.println("Đăng nhập không thành công. Vui lòng thử lại hoặc đăng ký nếu bạn chưa có tài khoản.");
                    }
                    break;
                case "3":
                    System.out.println("Thoát...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } else {
            System.out.println("Enter 1: Thêm");
            System.out.println("Enter 2: Sửa");
            System.out.println("Enter 3: Xóa theo passport");
            System.out.println("Enter 4: Tính tiền theo passport");
            System.out.println("Enter 5: Show");
            System.out.println("Enter 6. Ghi file");
            System.out.println("Enter 7. Đọc file");
            System.out.println("Enter 8. Thoát");
            String line = scanner.nextLine();
            switch(line) {
                    case "1": {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter passport: ");
                        scanner.nextLine();
                        String passport = scanner.nextLine();
                        System.out.println("Chọn Room A");
                        System.out.println("Chọn Room B");
                        System.out.println("Chọn Room C");
                        String choise = scanner.nextLine();
                        Room room;
                        if (choise.equals("a")) {
                            room = new RoomA();
                        } else if (choise.equals("b")) {
                            room = new RoomB();
                        } else if (choise.equals("c")) {
                            room = new RoomC();
                        } else {
                            continue;
                        }
                        System.out.print("Nhập Ngày Thuê: ");
                        int numberRent = scanner.nextInt();
                        Person person = new Person(name, age, passport, room, numberRent);
                        hotel.add(person);
                        scanner.nextLine();
                        break;
                    }
                    case "2":{
                        System.out.println("Enter passport update:");
                        String passport = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.println("Chọn Room A");
                        System.out.println("Chọn Room B");
                        System.out.println("Chọn Room C");
                        String choice = scanner.next();
                        Room room;
                        if (choice.equals("a")) {
                            room = new RoomA();
                        } else if (choice.equals("b")) {
                            room = new RoomB();
                        } else if (choice.equals("c")) {
                            room = new RoomC();
                        } else {
                            continue;
                        }
                        System.out.print("Nhập Ngày Thuê: ");
                        int numberRent = scanner.nextInt();
                        Person updatedPerson = new Person(name, age, passport, room, numberRent);
                        hotel.update(passport, updatedPerson);
                        scanner.nextLine();
                        break;
                    }

                    case "3": {
                        System.out.print("Enter passport: ");
                        String passport = scanner.nextLine();
                        hotel.delete(passport);
                        break;
                    }
                    case "4": {
                        System.out.print("Enter passport: ");
                        String passport = scanner.nextLine();
                        System.out.println("Price: " + hotel.calculator(passport));
                        break;
                    }
                    case "5": {
                        hotel.show();
                        break;
                    }
                    case "6": {
                        Hotel.writerHotel();
                        break;
                    }
                    case "7": {
                        Hotel.readHotel();
                        break;
                    }
                    case "8": {
                        return;
                    }
                    default:
                        System.out.println("Invalid");
                        continue;

                    }
        }
    }
}



}
