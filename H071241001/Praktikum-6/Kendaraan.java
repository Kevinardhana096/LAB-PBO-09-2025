public abstract class Kendaraan {
    protected String merk;
    protected int tahunProduksi;
    
    public Kendaraan(String merk, int tahunProduksi) {
        this.merk = merk;
        this.tahunProduksi = tahunProduksi;
    }
    
    public abstract void info();
}