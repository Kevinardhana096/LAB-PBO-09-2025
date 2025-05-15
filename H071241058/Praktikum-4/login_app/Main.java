package login_app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
            default:
                // Mengulang Pemanggilan Menu Utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.next();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;   //todo
                break;
            }
        }
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);  //todo

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));  //to do
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        } 
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();
        //todo
        while (username.isEmpty() || isUsernameTaken(username)) {
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong. Silakan masukkan ulang:");
            } else {
                System.out.println("Username sudah digunakan. Silakan masukkan username lain:");
            }
            System.out.print("> ");
            username = sc.nextLine();
        }
        
        while (password.length() < 8) {
            System.out.println("Password minimal 8 karakter. Silakan masukkan ulang:");
            System.out.print("> ");
            password = sc.nextLine();
        }

        User user = new User(username, password); //todo
        Profile profile = new Profile();

        // Menginput Data Profile
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

        //todo
        while (fullName.isEmpty()) {
            System.out.println("Nama Lengkap tidak boleh kosong. Silakan masukkan ulang:");
            System.out.print("> ");
            fullName = sc.nextLine();
        }
        profile.setFullName(fullName);
        
        // Validasi age
        while (true) {
            try {
                System.out.println("Umur");
                System.out.print("> ");
                age = sc.nextInt();
                sc.nextLine();
                if (age <= 0) {
                    System.out.println("Umur harus lebih dari 0. Silakan masukkan ulang:");
                } else {
                    break; // Umur valid, keluar dari loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Input bukan angka. Silakan masukkan ulang:");
                sc.nextLine(); // clear buffer
            }
        }
        profile.setAge(age);
            
        
        // Validasi hobby
        while (hobby.isEmpty()) {
            System.out.println("Hobby tidak boleh kosong. Silakan masukkan ulang:");
            System.out.print("> ");
            hobby = sc.nextLine();
        }
        profile.setHobby(hobby);

        String nickName = StringUtils.generateNickName(fullName);  //todo
        profile.setNickName(nickName);
        

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        //todo
        System.out.println("-------------------------");
        System.out.println("Data Profil:");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nama Panggilan : " + profile.getNickName());
        System.out.println("Age       : " + profile.getAge());
        System.out.println("Hobby     : " + profile.getHobby());
        System.out.println("-------------------------");
    }
    private static boolean isUsernameTaken(String username) {
        for (User u : listUser) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
