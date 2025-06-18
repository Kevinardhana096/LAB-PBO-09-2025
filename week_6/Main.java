package WEEK_6;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Uji Mobil
        System.out.println("==== MOBIL ====");
        Mobil mobil = new Mobil("Toyota", "Sport", 0, "Modern");
        mobil.setJumlahKursi(7);
        mobil.setBahanBakar("Bensin");
        System.out.println("Merk Mobil: " + mobil.getMerek());
        mobil.mulai();
        mobil.setKecepatan(60);
        mobil.hitungPajak();
        mobil.periksaKondisi();
        mobil.lakukanServis();
        System.out.println("Servis berikutnya: " + sdf.format(mobil.getWaktuServisBerikutnya()));
        mobil.hitungBiayaServis();
        System.out.println();

        // Uji Motor
        System.out.println("==== MOTOR ====");
        Motor motor = new Motor("Yamaha", "Aerox", "Modern");
        motor.setKapasitasTangki(12);
        motor.setTipeSuspensi("Upside-down");
        System.out.println("Merk Motor: " + motor.getMerek());
        motor.mulai();
        motor.setKecepatan(80);
        motor.updateKilometer(15000);
        motor.hitungPajak();
        motor.periksaKondisi();
        motor.lakukanServis();
        System.out.println("Servis berikutnya: " + sdf.format(motor.getWaktuServisBerikutnya()));
        motor.hitungBiayaServis();
        System.out.println();

        // Uji Sepeda
        System.out.println("==== SEPEDA ====");
        Sepeda sepeda = new Sepeda("Polygon", "MTB", "Konvensional");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        sepeda.mulai();
        sepeda.setKecepatan(25);
        sepeda.hitungPajak();
        sepeda.periksaKondisi();
        sepeda.lakukanServis();
        System.out.println("Servis berikutnya: " + sdf.format(sepeda.getWaktuServisBerikutnya()));
        sepeda.hitungBiayaServis();
        System.out.println();

        // Uji Kuda
System.out.println("==== KUDA ====");
Kuda kuda = new Kuda("K001", "Arabian", "PacuMax", "Coklat", 2020, "Kuda Pacu");
System.out.println("Jenis Kuda: " + kuda.getJenisKuda());
System.out.println("Merk Kuda: " + kuda.getMerek());
kuda.mulai();
kuda.setKecepatan(15);
kuda.berhenti();
System.out.println("Tipe Kendaraan: " + kuda.getTipeKendaraan());
System.out.println("Pajak Kuda: Rp " + kuda.hitungPajak());
System.out.println();

    }
}
