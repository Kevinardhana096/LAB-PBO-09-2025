package game;
import java.util.Random;

public class Petarung extends Hero {
    private boolean stunned = false;

    Petarung(String nama, int darah, int serangan) {
        super(nama, darah, serangan);
    }

    @Override
    void serang(Hero target) {
        System.out.println(nama + " memakai Tusukan Dewa, Damage: " + serangan);
        target.terimaSerangan(this.serangan);
        Random random = new Random();
        if (random.nextInt(3) == 0 && target instanceof Petarung) {
            ((Petarung) target).kenaStun(); 
            System.out.println(target.nama + " terkena stun!");
        }
        this.dapatkanPengalaman(20);
    }

    public void kenaStun() {
        this.stunned = true;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void resetStun() {
        this.stunned = false;
    }

    @Override
    void terimaSerangan(int damage) {
        if (!stunned) {
            super.terimaSerangan(damage);
        } else {
            System.out.println(nama + " sedang terkena stun dan tidak bisa bergerak!");
            resetStun();
        }
    }
}