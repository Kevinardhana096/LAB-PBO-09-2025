import java.util.Random;

public class Mafia {
    String nama;
    Senjata senjata = new Senjata();
    Pelindung pelindung = new Pelindung();
    int health = 100;

    public Mafia(String nama) {
        this.nama = nama;
    }

    public Mafia(String nama, int health) {
        this.nama = nama;
        this.health = health;
    }

    public Mafia(String nama, String namaSenjata, int kaliber, double panjangPeluru, String pelindungKepala, String pelindungBadan) {
        this.nama = nama;
        this.senjata.namaSenjata = namaSenjata;
        this.senjata.peluru.kaliber = kaliber;
        this.senjata.peluru.panjangPeluru = panjangPeluru;
        this.pelindung.kepala = pelindungKepala;
        this.pelindung.badan = pelindungBadan;
    }

    public Mafia(String nama, String namaSenjata, int kaliber, double panjangPeluru, String pelindungKepala, String pelindungBadan, int health) {
        this.nama = nama;
        this.senjata.namaSenjata = namaSenjata;
        this.senjata.peluru.kaliber = kaliber;
        this.senjata.peluru.panjangPeluru = panjangPeluru;
        this.pelindung.kepala = pelindungKepala;
        this.pelindung.badan = pelindungBadan;
        this.health = health;
    }

    public void shoot(Mafia musuh) {
        Random random = new Random();

        int randomTarget = random.nextInt(2); 
        String target = randomTarget == 0 ? "Badan" : "Kepala"; 

        this.health -= (musuh.senjata.getDamageTembakan(target) - this.pelindung.getDef(randomTarget));
        if (target.equals("Kepala")) {
            System.out.printf("%s terkena tembakan di %s oleh %s, tambahan 10 damage!\n", this.nama, target, musuh.nama);
        } else {
            System.out.printf("%s terkena tembakan di %s oleh %s, tambahan 5 damage!\n", this.nama, target, musuh.nama);
        }

        if (this.health <= 0) {
            System.out.println();
            System.out.printf("%s tumbang setelah tembakan!\n", this.nama);
            return;  
        }

        int randomTargetMusuh = random.nextInt(2);  
        String targetMusuh = randomTargetMusuh == 0 ? "Badan" : "Kepala"; 

        musuh.health -= (this.senjata.getDamageTembakan(targetMusuh) - musuh.pelindung.getDef(randomTargetMusuh));
        if (targetMusuh.equals("Kepala")) {
            System.out.printf("%s terkena tembakan di %s oleh %s, tambahan 10 damage!\n", musuh.nama, targetMusuh, this.nama);
        } else {
            System.out.printf("%s terkena tembakan di %s oleh %s, tambahan 5 damage!\n", musuh.nama, targetMusuh, this.nama);
        }

        if (musuh.health <= 0) {
            System.out.println();
            System.out.printf("%s tumbang setelah tembakan!\n", musuh.nama);
        }
    }

    public void checkStatus() {
        System.out.printf("=========== Status %s ===========\n", nama);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Senjata\t\t: " + senjata.getNamaSenjata() + ", " + senjata.peluru.getPeluru());
        System.out.println("Damage Tembakan\t: " + senjata.getDamageTembakan());
        System.out.println("Pelindung\t: " + pelindung.getPelindung());
        if (health <= 0) {
            System.out.println("Health\t\t: " + nama + " tumbang!");
        } else {
            System.out.println("Health\t\t: " + health);
        }
    }
}
