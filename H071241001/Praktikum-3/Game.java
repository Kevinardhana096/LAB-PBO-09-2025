public class Game {
    String nama;
    int tiketDibutuhkan;
    int poinHadiah;

    public Game(){
        nama ;
        tiketDibutuhkan;
        poinHadiah;
    }

    public Game(String nama, int tiketDibutuhkan, int poinHadiah) {
        this.nama = nama;
        this.tiketDibutuhkan = tiketDibutuhkan;
        this.poinHadiah = poinHadiah;
    }

    public void info() {
        System.out.println(nama + " | Tiket: " + tiketDibutuhkan + " | Hadiah: " + poinHadiah + " poin");
    }
}
