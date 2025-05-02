package game;

public class Pemanah extends Hero{
    Pemanah(String nama, int darah, int serangan){
        super(nama, darah, serangan);
    }

    void serang(){
        System.out.println(nama + " memakai Dance Pembunuh (come on dexter), Damage: " + serangan);
    }
}
