
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan n: ");
        int n = scanner.nextInt();

        int hasil = faktorial(n);

        System.out.println("Faktorial dari " + n + " adalah: " + hasil);

        scanner.close();
    }

    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        } else {
            return n * faktorial(n - 1); 
        }
    }
}
