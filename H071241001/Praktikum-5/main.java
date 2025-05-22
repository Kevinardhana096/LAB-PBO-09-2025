import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Pilih karakter: ");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Masukkan nama: ");
        String name = scanner.nextLine();
        System.out.println("Masukkan health: ");
        int health = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Masukkan attack power: ");
                int archerPower = scanner.nextInt();
                hero = new Archer(name, health, archerPower);
                break;
            case 2:
                System.out.print("Masukkan attack power: ");
                int wizardPower = scanner.nextInt();
                hero = new Wizard(name, health, wizardPower);
                break;
            case 3:
                hero = new Fighter(name, health); 
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                System.exit(0);
        }
        while (true) {
            System.out.println("\nPilih aksi:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            int action = scanner.nextInt();

            if (action == 1) {
                hero.attack();
            } else if (action == 2) {
                System.out.println("Program berakhir.");
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}