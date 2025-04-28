import java.util.ArrayList;
import java.util.Scanner;
import models.Profile;
import models.User;
import utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
            default:
                runApp();
        }
    }

    private static void showLoginMenu() {
        for (int n = 2 ; n >= 0 ; n--){
            System.out.println("-------------------------");
            System.out.println("Login");
            System.out.println("Masukkan Username");
            System.out.print("> ");

            String username = sc.next();
            int userIndex = -1;
            for (int i = 0; i < listUser.size(); i++) {
                if (username.equals(listUser.get(i).getUsername())) {
                    userIndex = i;
                    break;
                } else {
                    continue;
                }
            }
            if (userIndex != -1) {
                System.out.println("Password");
                System.out.print("> ");
                String password = sc.next();
                boolean isPasswordMatch;
                if (password.equals(listUser.get(userIndex).getPassword())) {
                    isPasswordMatch = true;
                } else {
                    isPasswordMatch = false;
                }

                if (isPasswordMatch) {
                    System.out.println("Berhasil Login");
                    showDetailUser(listUserProfile.get(userIndex));
                    System.exit(0);
                 
                } else {
                    System.out.println("Password Salah");
                    System.out.println("tersisa " + n + " kesempatan lagi");
                }
            } else {
                System.out.println("username tidak ditemukan");
                System.out.println("tersisa " + n + " kesempatan lagi");
            }
        }
        System.out.println("-------------------------");
        System.out.println("password & username salah");
        System.out.println("tunggu beberapa saat lagi.");
        System.exit(0);
    }
    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");
    
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
    
        // Fitur Tambahan Handle saat password < 8 karakter, maka akan diminta input ulang
        System.out.println("Password");
        String password;
        while (true) {
            System.out.print("> ");
            password = sc.nextLine();
            if (password.length() >= 8) {
                break;
            } else {
                System.out.println("Password harus minimal 8 karakter. Silakan masukkan ulang.");
            }
        }
    
        User user = new User(username, password);
    
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        System.out.println("Umur");
        System.out.print("> ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
    
        Profile profile = new Profile(StringUtils.MadeNickame(fullName), fullName, age, hobby);
    
        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("user baru berhasil dibuat");
        runApp();
    }
    

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("SELAMAT DATANG");
        System.out.println("-------------------------");
        System.out.println("Nama Lengkap\t: " + profile.getName());
        System.out.println("Nama Panggilan\t: " + profile.getNickname());
        System.out.println("Umur\t\t: " + profile.getAge());
        System.out.println("Hobby\t\t: " + profile.getHobby());
    }
}