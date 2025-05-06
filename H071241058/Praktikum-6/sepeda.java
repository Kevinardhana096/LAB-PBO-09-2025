class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;

    public Sepeda(String merek, String model) {
        super(merek, model);
        this.jenisSepeda = "Lipat";
        this.jumlahGear = 10;
        this.ukuranRoda = 40; //dlm cm
        this.kecepatan = 0; 
    }

    public String getJenisSepeda() { return jenisSepeda; }
    public void setJenisSepeda(String jenis) { this.jenisSepeda = jenis; }

    public int getJumlahGear() { return jumlahGear; }
    public void setJumlahGear(int jumlah) { this.jumlahGear = jumlah; }

    public int getUkuranRoda() { return ukuranRoda; }
    public void setUkuranRoda(int ukuran) { this.ukuranRoda = ukuran; }

    @Override
    public double hitungPajak() {
        double tambahanBiaya = jenisSepeda.equalsIgnoreCase("Lipat") ? 10000 : 30000;
        return 15000 + tambahanBiaya;}

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    @Override
    public boolean mulai() {
        kecepatan = 15;
        System.out.println("Sepeda mulai melaju dengan kecepatan " + kecepatan + " km/jam.");
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
        System.out.println("Motor berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }

    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    @Override
    public boolean periksaKondisi() {
        boolean kondisiBaik = Math.random() > 0.2;
        System.out.println("Hasil pemeriksaan kondisi sepeda: " + (kondisiBaik ? "Baik" : "Perlu servis"));
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Sepeda diservis");
    }

    @Override
    public java.util.Date getWaktuServisBerikutnya() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.MONTH, 4);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biayaDasar = jenisSepeda.equalsIgnoreCase("Lipat") ? 100000 : 80000;
        return biayaDasar + 24000;
    }
}
