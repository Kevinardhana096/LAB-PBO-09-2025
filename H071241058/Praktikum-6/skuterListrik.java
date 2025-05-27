class SkuterListrik extends Kendaraan implements IBergerak {
    private int kapasitasBaterai;
    private double kecepatan;

    public SkuterListrik(String merek, String model) {
        super(merek, model);
        this.kapasitasBaterai = 5000 ;//watt
        this.kecepatan = 0;
    }

    public int getKapasitasBaterai() { return kapasitasBaterai; }
    public void setKapasitasBaterai(int kapasitas) { this.kapasitasBaterai = kapasitas; }

    @Override
    public double hitungPajak() {
        return kapasitasBaterai * 1000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Skuter Listrik";
    }

    @Override
    public boolean mulai() {
        kecepatan = 25;
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }

    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }
}
