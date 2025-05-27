public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private boolean isMatik;
    private int kapasitasTangki;
    private int jarakTempuh;
    
    public Motor(String merk, int tahunProduksi, boolean isMatik, int kapasitasTangki) {
        super(merk, tahunProduksi);
        this.isMatik = isMatik;
        this.kapasitasTangki = kapasitasTangki;
        this.jarakTempuh = 0;
    }
    
    @Override
    public void info() {
        System.out.println("Motor " + merk + " (" + tahunProduksi + ")");
        System.out.println("- Tipe: " + (isMatik ? "Matic" : "Manual"));
        System.out.println("- Tangki: " + kapasitasTangki + " liter");
        System.out.println("- Jarak Tempuh: " + jarakTempuh + " km");
    }
    
    // Method dari IBergerak
    @Override
    public void maju() {
        System.out.println(merk + " ngebut");
        jarakTempuh += 5;
    }
    
    @Override
    public void berhenti() {
        System.out.println(merk + " mengerem");
    }
    
    // Method dari IServiceable
    @Override
    public void service() {
        System.out.println("Servis motor " + merk);
        System.out.println("- Ganti oli");
        System.out.println("- Cek rantai");
        jarakTempuh = 0;
    }
    
    @Override
    public boolean periksaKondisi() {
        return jarakTempuh > 3000;
    }
    
    // Method khusus
    public void wheelie() {
        System.out.println(merk + " wheelie!");
    }
}