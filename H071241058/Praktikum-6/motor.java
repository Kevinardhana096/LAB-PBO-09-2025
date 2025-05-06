class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
        this.jenisMotor = "Sport";           
        this.kapasitasTangki = 12;             
        this.tipeSuspensi = "Upside Down";    
        this.kecepatan = 0;                  
        this.setTahunProduksi(2021);           
        this.setWarna("Merah");               
    }


    public String getJenisMotor() { return jenisMotor; }
    public void setJenisMotor(String jenis) { this.jenisMotor = jenis; }

    public double getKapasitasTangki() { return kapasitasTangki; }
    public void setKapasitasTangki(double kapasitas) { this.kapasitasTangki = kapasitas; }

    public String getTipeSuspensi() { return tipeSuspensi; }
    public void setTipeSuspensi(String tipe) { this.tipeSuspensi = tipe; }

    @Override
    public double hitungPajak() {
        double tambahanJenis = jenisMotor.equalsIgnoreCase("Sport") ? 50000 : 30000;
        return (kapasitasTangki * 20000) + tambahanJenis;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        kecepatan = 30; 
        System.out.println("Motor mulai melaju dengan kecepatan " + kecepatan + " km/jam.");
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
        System.out.println("Hasil pemeriksaan kondisi motor: " + (kondisiBaik ? "Baik" : "Perlu servis"));
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Motor diservis: Ganti oli, cek rem, servis karburator");
    }

    @Override
    public java.util.Date getWaktuServisBerikutnya() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.MONTH, 4);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biayaDasar = jenisMotor.equalsIgnoreCase("Sport") ? 100000 : 80000;
        return biayaDasar + (kapasitasTangki * 5000);
    }
}
