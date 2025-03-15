import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long angka = scanner.nextInt();

        System.out.println(faktorial(angka));

        scanner.close();
    }

    public static long faktorial(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }
}
