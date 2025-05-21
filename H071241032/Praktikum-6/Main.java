public class Main {
    public static void main(String[] args) {
        Minato minato = new Minato("Minato Namikaze", "Si kilat kuning dari konoha");
        Mobil mobil = new Mobil("Honda", "H-RV");
        Motor motor = new Motor("Yamaha", "NMAX");
        Sepeda sepeda = new Sepeda("Polygon", "Monarch");
        System.out.println("Kecepatan Minato: " + minato.getKecepatan());
        minato.aktifkanModeSage();
        minato.gunakanRasengan();
        System.out.println("Stat" + minato.getTipeKendaraan());
        System.out.println();
        mobil.setKecepatan(300);
        mobil.setKapasitasmesin(12.5);
        System.out.println("Kecepatan Mobil: " + mobil.getKecepatan());
        mobil.lakukanServis();
        System.out.println("Tipe kendaraan Mobil: " + mobil.getTipeKendaraan());
        System.out.println("Pajak Mobil: Rp " + mobil.hitungPajak());
        System.out.println();
        motor.setKecepatan(90);
        motor.setKapasitastangki(4.0);
        System.out.println("Kecepatan Motor: " + motor.getKecepatan());
        motor.lakukanServis(us Minato: );
        System.out.println("Tipe kendaraan Motor: " + motor.getTipeKendaraan());
        System.out.println("Pajak Motor: Rp " + motor.hitungPajak());
        System.out.println();
        sepeda.setKecepatan(30);
        System.out.println("Kecepatan Sepeda: " + sepeda.getKecepatan());
        sepeda.lakukanServis();
        System.out.println("Tipe kendaraan Sepeda: " + sepeda.getTipeKendaraan());
    }
}
