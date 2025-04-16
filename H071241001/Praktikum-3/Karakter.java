public class Karakter {
    String nama;
    int tiket;
    int poin;
    Game game;

    public Karakter(){
        nama = "Femi";
        tiket = 9;
    }

    public Karakter(String nama, int tiket) {
        this.nama = nama;
        this.tiket = tiket;
        this.poin = 0;
    }

    public void mainGame(Game game) {
        if (tiket >= game.tiketDibutuhkan) {
            tiket -= game.tiketDibutuhkan;
            poin += game.poinHadiah;
            System.out.println(nama + " memainkan " + game.nama + " dan mendapatkan " + game.poinHadiah + " poin.");
        } else {
            System.out.println(nama + " tidak memiliki cukup tiket untuk bermain " + game.nama + ".");
        }
    }

    public void cekStatus() {
        System.out.println("[" + nama + "] Tiket: " + tiket + " | Poin: " + poin);
    }

    public void tukarPoin() {
        if (poin >= 5) {
            poin -= 5;
            System.out.println(nama + " menukar 5 poin dengan hadiah menarik!");
        } else {
            System.out.println("Poin belum cukup untuk ditukar hadiah. (Butuh 5 poin)");
        }
    }
}
