import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        System.out.println((isValid(password) ? "Password valid" : "Password tidak valid"));

        scanner.close();
    }

    public static boolean isValid(String p) {
        if (p.length() < 8) return false;

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (char c : p.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }
            
            if (adaHurufBesar && adaHurufKecil && adaAngka) {
                return true;
            }
        }

        return false;
    }
}