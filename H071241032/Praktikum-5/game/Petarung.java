package game;

public class Petarung {
    Petarung(String nama, int darah, int serangan){
        super(nama, darah, serangan);
    }
    void serang(){
        System.out.println(nama + " memakai Tusukan Dewa, Damage: " + serangan);
    }
}
