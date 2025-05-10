public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private String jenisBahanBakar;
    private int jarakTempuh;
    
    public Mobil(String merk, int tahunProduksi, int jumlahPintu, String jenisBahanBakar) {
        super(merk, tahunProduksi);
        this.jumlahPintu = jumlahPintu;
        this.jenisBahanBakar = jenisBahanBakar;
        this.jarakTempuh = 0;
    }
    
    @Override
    public void info() {
        System.out.println("Mobil " + merk + " (" + tahunProduksi + ")");
        System.out.println("- Pintu: " + jumlahPintu);
        System.out.println("- Bahan Bakar: " + jenisBahanBakar);
        System.out.println("- Jarak Tempuh: " + jarakTempuh + " km");
    }
    
    // Method dari IBergerak
    @Override
    public void maju() {
        System.out.println(merk + " bergerak maju");
        jarakTempuh += 10;
    }
    
    @Override
    public void berhenti() {
        System.out.println(merk + " berhenti");
    }
    
    // Method dari IServiceable
    @Override
    public void service() {
        System.out.println("Servis mobil " + merk);
        System.out.println("- Ganti oli");
        System.out.println("- Cek mesin");
        jarakTempuh = 0;
    }
    
    @Override
    public boolean periksaKondisi() {
        return jarakTempuh > 5000;
    }
    
    // Method khusus
    public void klakson() {
        System.out.println("Tin! Tin!");
    }
}