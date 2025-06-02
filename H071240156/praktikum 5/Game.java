import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hero hero = null;

        System.out.println("=== Pilih karakter ===");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();

        input.nextLine();

        System.out.print("Masukkan nama karakter: ");
        String nama = input.nextLine();

        switch (pilihan) {
            case 1:
                hero = new Archer(nama);
                break;
            case 2:
                hero = new Wizard(nama);
                break;
            case 3:
                hero = new Fighter(nama);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                System.exit(0);
        }
        int menu;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Serang");
            System.out.println("2. keluar");
            System.out.print("Pilihanmu = ");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    hero.attack();
                    break;
                case 2:
                    System.out.println("Keluar dari game");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (menu != 2);
        input.close();
    }
}
