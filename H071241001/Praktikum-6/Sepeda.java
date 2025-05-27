public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahGigi;
    private String jenisRem;
    private int jarakTempuh;
    
    public Sepeda(String merk, int tahunProduksi, int jumlahGigi, String jenisRem) {
        super(merk, tahunProduksi);
        this.jumlahGigi = jumlahGigi;
        this.jenisRem = jenisRem;
        this.jarakTempuh = 0;
    }
    
    @Override
    public void info() {
        System.out.println("Sepeda " + merk + " (" + tahunProduksi + ")");
        System.out.println("- Gigi: " + jumlahGigi);
        System.out.println("- Rem: " + jenisRem);
        System.out.println("- Jarak Tempuh: " + jarakTempuh + " km");
    }
    
    // Method dari IBergerak
    @Override
    public void maju() {
        System.out.println(merk + " dikayuh");
        jarakTempuh += 1;
    }
    
    @Override
    public void berhenti() {
        System.out.println(merk + " direm");
    }
    
    // Method dari IServiceable
    @Override
    public void service() {
        System.out.println("Servis sepeda " + merk);
        System.out.println("- Lumasi rantai");
        System.out.println("- Cek rem");
        jarakTempuh = 0;
    }
    
    @Override
    public boolean periksaKondisi() {
        return jarakTempuh > 500;
    }
    
    // Method khusus
    public void bunyikanBel() {
        System.out.println("Kring! Kring!");
    }
}