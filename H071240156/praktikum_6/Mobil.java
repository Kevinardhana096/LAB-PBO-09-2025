package praktikum_6;

import java.util.Date;
import java.util.Calendar;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;
    private Date tanggalServis;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) {
        this.kapasitasMesin = kapasitas;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlah) {
        this.jumlahKursi = jumlah;
    }

    public String getBahanBakar() {
        return bahanBakar;

    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public int getTahunProduksi() {
        return tahunProduksi;
    }

    @Override
    public void setTahunProduksi(int tahun) {
        this.tahunProduksi = tahun;
    }

    @Override
    public double hitungPajak() {
        int nilaiTahun;
        if (tahunProduksi >= 1900 && tahunProduksi <= 2000) {
            nilaiTahun = 200;
        } else if (tahunProduksi >= 2001 && tahunProduksi <= 2025) {
            nilaiTahun = 300;
        } else {
            nilaiTahun = 100;
        }
        return kapasitasMesin * nilaiTahun;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";

    }

    // IBERGERAK
    @Override
    public boolean mulai() {
        System.out.println("Mobil dinyalakan..");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti..");
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
        System.out.println("Memeriksa kondisi mobil..");
        return true;
    }

    @Override
    public void lakukanService() {
        tanggalServis = new Date();
        System.out.println("Mobil sudah diservis");
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
        return 20000 + (kapasitasMesin * kecepatan);
    }
}
