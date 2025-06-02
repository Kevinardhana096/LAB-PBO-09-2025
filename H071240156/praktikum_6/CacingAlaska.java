package praktikum_6;

public class CacingAlaska extends Kendaraan implements IBergerak {
    private double panjang;
    private double kecepatan;

    public CacingAlaska(String merek, String model) {
        super(merek, model);
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    @Override
    public double hitungPajak() {
        return panjang * kecepatan;
    }

    @Override
    public String getTipeKendaraan() {
        return "Cacing Alaska";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Cacing Alaska mulai meliuk-liuk..");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Cacing Alaska berhenti meliuk..");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
}
