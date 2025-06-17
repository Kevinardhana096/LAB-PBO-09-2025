import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan: ");
        long n = scanner.nextInt();

        System.out.println(faktorial(n));

        scanner.close();
    }

    public static long faktorial(long n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
        return n * faktorial(n - 1);
    }
}