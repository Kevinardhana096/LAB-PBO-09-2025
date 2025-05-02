package game;

public class Penyihir {
    Penyihir(String nama, int darah, int serangan){
        super(nama, darah, serangan);
    }

    void serang(){
        System.out.println(nama + " memakaiLaser Mematikan, Damage: " + serangan);
    }
}
