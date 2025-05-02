package game;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = null;
        System.out.println("1. Pemanah");
        System.out.println("2. Petarung");
        System.out.println("3. Penyihir");
        int pilihan = sc.nextInt();
        switch(pilihan) {
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
        while(true){
            System.out.println("+=+= MOBA LEJENG =+=+");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            int menu = sc.nextInt();
            if(menu == 1){
                hero.serang();
            } else if(menu == 2){
                System.out.println("Game berhenti, disuruh mama pergi beli garam.");
                break;
            } else {
                System.out.println("Pilih angka 1 atau 2 saja.");
            }
        }

        sc.close();
    }
}
