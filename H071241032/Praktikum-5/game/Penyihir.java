
public class Penyihir extends Hero {
    int mana;

    Penyihir(String nama, int darah, int serangan) {
        super(nama, darah, serangan);
        this.mana = 100; 
    }

    @Override
    void serang(Hero target) {
        if (mana >= 15) { 
            int magicDamage = (int) (this.serangan * 1.5); 
            System.out.println(nama + " meluncurkan Bola Api Mistis, Damage: " + magicDamage + " (Mana -" + 15 + ")");
            target.terimaSerangan(magicDamage);
            this.mana -= 15;
            this.dapatkanPengalaman(25); 
        } else {
            System.out.println(nama + " tidak memiliki cukup mana untuk menyerang!");
        }
    }

    public void lihatStatus() {
        super.lihatStatus();
        System.out.println("Mana: " + mana);
    }
}