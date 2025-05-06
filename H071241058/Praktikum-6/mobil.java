class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
        this.jumlahPintu = 4;              
        this.kapasitasMesin = 1.5;         
        this.jumlahKursi = 5;              
        this.bahanBakar = "Bensin";       
        this.kecepatan = 0;              
        this.setTahunProduksi(2022);      
        this.setWarna("Hitam");           
    }


    public int getJumlahPintu() { return jumlahPintu; }
    public void setJumlahPintu(int jumlah) { this.jumlahPintu = jumlah; }

    public double getKapasitasMesin() { return kapasitasMesin; }
    public void setKapasitasMesin(double kapasitas) { this.kapasitasMesin = kapasitas; }

    public int getJumlahKursi() { return jumlahKursi; }
    public void setJumlahKursi(int jumlah) { this.jumlahKursi = jumlah; }

    public String getBahanBakar() { return bahanBakar; }
    public void setBahanBakar(String bahanBakar) { this.bahanBakar = bahanBakar; }

    @Override
    public double hitungPajak() {
        return (kapasitasMesin * 50000) + (jumlahKursi * 10000);
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() {
        kecepatan = 20; 
        System.out.println("Mobil mulai bergerak dengan kecepatan " + kecepatan + " km/jam.");
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
        System.out.println("Mobil berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }

    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    @Override
    public boolean periksaKondisi() {
        boolean kondisiBaik = Math.random() > 0.1;
        System.out.println("Hasil pemeriksaan kondisi mobil: " + (kondisiBaik ? "Baik" : "Perlu servis"));
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Mobil diservis: Ganti oli, periksa rem, cek mesin");
    }

    @Override
    public java.util.Date getWaktuServisBerikutnya() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        return 150000 + (kapasitasMesin * 100000);
    }
}
