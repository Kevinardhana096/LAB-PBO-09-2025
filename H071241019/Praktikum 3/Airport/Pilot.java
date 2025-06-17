public class Pilot {
    private String nama;
    public void setNama(String nama) {
        this.nama = nama;
    }

    private int jamTerbang;
    public void setJamTerbang(int jamTerbang) {
        this.jamTerbang = jamTerbang;
    }

    private int umur;

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public Pilot() {
        this.nama = "Tidak diketahui";
        this.jamTerbang = 0;
        this.umur = 0;
    }

    public Pilot(String nama, int jamTerbang, int umur) {
        this.nama = nama;
        this.jamTerbang = jamTerbang;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }
    
    public int getJamTerbang() {
        return jamTerbang;
    }

    public int getUmur() {
        return umur;
    }

    public void tambahJamTerbang(int jam) {
        this.jamTerbang += jam;
    }

    public void tampilkanInfo() {
        System.out.println("Pilot: " + nama + ", Jam Terbang: " + jamTerbang + ", Umur: " + umur);
    }
}
