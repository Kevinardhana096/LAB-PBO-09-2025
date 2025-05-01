import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                hero = new Archer();
                break;
            case 2:
                hero = new Wizard();
                break;
            case 3:
                hero = new Fighter();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        int aksi;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            aksi = input.nextInt();

            switch (aksi) {
                case 1:
                    hero.attack();
                    break;
                case 2:
                    System.out.println("Game selesai!");
                    break;
                default:
                    System.out.println("Aksi tidak valid.");
            }
        } while (aksi != 2);

        input.close();
    }
}
