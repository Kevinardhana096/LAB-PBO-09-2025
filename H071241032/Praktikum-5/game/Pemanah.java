package game;

import java.util.Random;

public class Pemanah extends Hero {
    Pemanah(String nama, int darah, int serangan) {
        super(nama, darah, serangan);
    }

    @Override
    void serang(Hero target) {
        Random random = new Random();
        if (random.nextInt(5) == 0) { 
            int criticalDamage = this.serangan * 2;
            System.out.println(nama + " melancarkan Dance Pembunuh (Critical Hit!), Damage: " + criticalDamage);
            target.terimaSerangan(criticalDamage);
        } else {
            System.out.println(nama + " memakai Dance Pembunuh, Damage: " + serangan);
            target.terimaSerangan(this.serangan);
        }
        this.dapatkanPengalaman(20);
    }
}