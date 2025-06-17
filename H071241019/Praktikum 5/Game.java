import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = null; 

        try {
            scanner = new Scanner(System.in);

            System.out.println("Pilih Karakter:");
            System.out.println("1. Pemanah (Archer)");
            System.out.println("2. Penyihir (Wizard)");
            System.out.println("3. Petarung (Fighter)");
            System.out.print("Masukkan pilihan: ");

            int pilihanKarakter = scanner.nextInt();
            scanner.nextLine(); 

            Hero karakter = null;
            switch (pilihanKarakter) {
                case 1:
                    karakter = new Archer("Archer");
                    break;
                case 2:
                    karakter = new Wizard("Wizard");
                    break;
                case 3:
                    karakter = new Fighter("Fighter");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    return;
            }

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Serang");
                System.out.println("2. Keluar");
                System.out.print("Masukkan pilihan: ");

                int pilihanMenu = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihanMenu) {
                    case 1:
                        karakter.attack();
                        break;
                    case 2:
                        System.out.println("Game Selesai!");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}