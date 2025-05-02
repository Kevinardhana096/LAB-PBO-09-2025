package game;
import java.util.Random;

public class Hero {
    String nama;
    int darah;
    int serangan;
    int level;
    int pengalaman;

    Hero(String nama, int darah, int serangan) {
        this.nama = nama;
        this.darah = darah;
        this.serangan = serangan;
        this.level = 1;
        this.pengalaman = 0;
    }

    void serang(Hero target) {
        System.out.println(nama + " menyerang " + target.nama + " dengan kekuatan: " + serangan);
        target.terimaSerangan(this.serangan);
        this.dapatkanPengalaman(20); 
    }

    void terimaSerangan(int damage) {
        this.darah -= damage;
        System.out.println(nama + " menerima " + damage + " damage. Darah tersisa: " + darah);
        if (this.darah <= 0) {
            System.out.println(nama + " telah dikalahkan!");
        }
    }

    void dapatkanPengalaman(int xp) {
        this.pengalaman += xp;
        System.out.println(nama + " mendapatkan " + xp + " pengalaman. Total pengalaman: " + pengalaman);
        cekLevelUp();
    }

    void cekLevelUp() {
        if (this.pengalaman >= level * 100) {
            level++;
            this.pengalaman -= level * 100;
            this.darah += 10;
            this.serangan += 5;
            System.out.println("++ " + nama + " naik level menjadi " + level + "! ++");
            System.out.println("Darah meningkat menjadi: " + this.darah);
            System.out.println("Serangan meningkat menjadi: " + this.serangan);
        }
    }

    void lihatStatus() {
        System.out.println("--- Status " + nama + " ---");
        System.out.println("Level: " + level);
        System.out.println("Darah: " + darah);
        System.out.println("Serangan: " + serangan);
        System.out.println("Pengalaman: " + pengalaman + "/" + (level * 100));
    }
}