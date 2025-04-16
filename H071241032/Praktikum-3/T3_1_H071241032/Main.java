package T3_1_H071241032;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nama penyewa: ");
        String nama = input.nextLine();

        System.out.print("Umur: ");
        int umur = input.nextInt();

        System.out.print("Uang yang dimiliki: ");
        int uang = input.nextInt();
        input.nextLine();
        System.out.print("Apakah kamu laki-laki? (ya/tidak): ");
        String gender = input.nextLine().toLowerCase();
        boolean lakiLaki = gender.equals("ya") || gender.equals("y");
        PenyewaKost penyewa = new PenyewaKost(nama, umur, uang, lakiLaki);
        Bapakkost pakDidit = new Bapakkost();
        pakDidit.prosesSewa(penyewa);
    }
}
