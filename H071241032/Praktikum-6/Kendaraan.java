

public abstract class Kendaraan {
    protected String id;
    protected String merek;
    protected String model;
    protected int tahunproduksi;
    protected String warna;
    public Kendaraan(String merek, String model){
        this.merek=merek;
        this.model=model;
    }
    public String getId(){
        return id;
    }
    public String getMerek(){
        return merek;
    }
    public String getModel(){
        return model;
    }
    public int getTahunproduksi(){
        return tahunproduksi;
    }
    public void setTahunproduksi(int tahunproduksi){
        this.tahunproduksi=tahunproduksi;
    }
    public String getWarna(){
        return warna;
    }
    public void setWarna(String warna){
        this.warna=warna;
    }
    public abstract double hitungPajak();
    public abstract String getTipeKendaraan();
}
