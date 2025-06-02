package praktikum_6;

import java.util.Calendar;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;
    private Date tanggalServis;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenis) {
        this.jenisSepeda = jenis;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlah) {
        this.jumlahGear = jumlah;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuran) {
        this.ukuranRoda = ukuran;
    }

    @Override
    public double hitungPajak() {
        return jumlahGear * 50000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";

    }

    // IBERGERAK
    @Override
    public boolean mulai() {
        System.out.println("Sepeda " + getMerek() + " " + getModel() + " dikayuh..");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda berhenti..");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    // ISERVICABLE
    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi sepeda..");
        return true;
    }

    @Override
    public void lakukanService() {
        tanggalServis = new Date();
        System.out.println("Sepeda sudah diservis");
    }

    @Override
    public Date getWaktuServiceBerikutnya() {
        if (tanggalServis == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(tanggalServis);
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaService() {
        return 50000 + (jumlahGear * 100000);
    }
}