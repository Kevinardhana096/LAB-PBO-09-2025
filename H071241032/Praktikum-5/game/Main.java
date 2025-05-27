// Fitur baru di Moba Lejeng secara singkat:
// Penyihir dengan Mana: Hero baru dengan serangan magis yang kuat, menggunakan sumber daya mana.
// Level & XP: Hero bisa naik level dengan mengumpulkan pengalaman, meningkatkan status.
// Efek Serangan Unik: Tiap hero punya efek khusus saat menyerang (critical, stun, magic damage).
// Lawan Monster: Pemain bisa bertarung melawan monster untuk menguji kemampuan dan mendapatkan pengalaman.
// Ada tambahan atribut yaitu level dan pengalaman
// Mobile Legend Bang bang. nooo, Moba LEJENG Ngeng Ngeng. yesss.
package game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Selamat datang di MOBA LEJENG!");
        System.out.println("Pilih hero kamu:");
        System.out.println("1. Pemanah");
        System.out.println("2. Petarung");
        System.out.println("3. Penyihir");
        System.out.print("Masukkan pilihan: ");
        int pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:
                hero = new Pemanah("Claude", 56, 97);
                break;
            case 2:
                hero = new Petarung("Martis", 120, 25);
                break;
            case 3:
                hero = new Penyihir("Gord", 49, 98);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                System.exit(0);
        }

        System.out.println("\nHero " + hero.nama + " telah terpilih!");

        while (hero.darah > 0) {
            System.out.println("\n+=+= MOBA LEJENG =+=+");
            hero.lihatStatus();
            System.out.println("1. Serang Monster");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                Hero monster = new Hero("Goblin", 30, 10);
                System.out.println("\n--- Pertarungan dimulai! ---");
                System.out.println("Musuhmu adalah: " + monster.nama + " (Darah: " + monster.darah + ")");

                while (hero.darah > 0 && monster.darah > 0) {
                    System.out.println("\n--- Giliranmu ---");
                    System.out.println("1. Serang");
                    System.out.print("Pilih aksi: ");
                    int aksi = sc.nextInt();
                    if (aksi == 1) {
                        hero.serang(monster);
                        if (monster.darah > 0) {
                            System.out.println("\n--- Giliran Monster ---");
                            monster.serang(hero);
                        }
                    } else {
                        System.out.println("Aksi tidak valid.");
                    }
                }

                if (hero.darah <= 0) {
                    System.out.println("\nKamu kalah!");
                    break;
                } else {
                    System.out.println("\nKamu mengalahkan " + monster.nama + "!");
                }

            } else if (menu == 2) {
                System.out.println("Game berhenti, disuruh mama pergi beli garam.");
                break;
            } else {
                System.out.println("Pilih angka 1 atau 2 saja.");
            }
        }

        if (hero.darah <= 0) {
            System.out.println("=== GAME OVER ===");
        }

        sc.close();
    }
}