package praktikum_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan merek mobil: ");
        String merek = sc.nextLine();

        System.out.print("Masukkan model mobil: ");
        String model = sc.nextLine();

        Mobil mobil = new Mobil(merek, model);
        // ==Jumlah Pintu===
        System.out.print("Masukkan jumlah pintu mobil: ");
        int jumlahPintu = sc.nextInt();
        mobil.setJumlahPintu(jumlahPintu);

        // ==Kapitas Mesin==
        System.out.print("Masukkan kapasitas mesin: ");
        double kapasitasMesin = sc.nextDouble();
        mobil.setKapasitasMesin(kapasitasMesin);

        // ==Jumlah Kursi==
        System.out.print("Masukkan jumlah kursi: ");
        int jumlahKursi = sc.nextInt();
        mobil.setJumlahKursi(jumlahKursi);

        sc.nextLine();
        // == Bahan Bakar==
        System.out.print("Masukkan jenis bahan bakar: ");
        String bahanBakar = sc.nextLine();
        mobil.setBahanBakar(bahanBakar);

        // == kecepatan ==
        System.out.print("Masukkan kecepatan mobil km/jam: ");
        double kecepatan = sc.nextDouble();
        mobil.setKecepatan(kecepatan);

        // == tahun produksi ==
        System.out.print("Masukkan tahu produksi mobil: ");
        int tahunProduksi = sc.nextInt();
        mobil.setTahunProduksi(tahunProduksi);

        sc.close();

        // Tampilkan informasi
        System.out.println("\n==== Informasi Mobil ====");
        System.out.println("Tipe: " + mobil.getTipeKendaraan());
        System.out.println("Merek: " + mobil.getMerek());
        System.out.println("Model: " + mobil.getModel());
        System.out.println("Kecepatan Mobil: " + mobil.getKecepatan() + "km/jam");
        System.out.println("Tahun produksi mobil adalah tahun " + mobil.getTahunProduksi());
        System.out.println("Pajak: Rp" + mobil.hitungPajak());
        System.out.println("Biaya Service: Rp" + mobil.hitungBiayaService());

        mobil.mulai();
        mobil.berhenti();
        mobil.lakukanService();
        System.out.println("Waktu service berikutnya: " + mobil.getWaktuServiceBerikutnya());
    }
}
