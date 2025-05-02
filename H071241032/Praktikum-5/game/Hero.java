package game;

public class Hero {
    String nama;
    int darah;
    int serangan;

    Hero(String nama, int darah, int serangan){
        this.nama = nama;
        this.darah = darah;
        this.serangan = serangan;
    }
    void serang(){
        System.out.println(nama + " menyerang dengan kekuatan: " + serangan);
    }
}
