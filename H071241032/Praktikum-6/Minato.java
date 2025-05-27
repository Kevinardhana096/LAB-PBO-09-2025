public class Minato extends Kendaraan implements IBergerak {
    private double kecepatan;
    private double chakra;
    private boolean modeSageAktif;

    public Minato(String nama, String julukan) {
        super(nama, julukan); 
        this.kecepatan = 9_000_000;
        this.chakra = 100;
        this.modeSageAktif = false;
    }
    @Override
    public boolean mulai() {
        System.out.println("Melempar semua kunai");
        return true;
    }
    @Override
    public boolean berhenti() {
        System.out.println("sedang mengamati musuh plernya");
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
    public void aktifkanModeSage() {
        if (!modeSageAktif) {
            modeSageAktif = true;
            chakra -= 50;
            System.out.println("Mode sage on, sia chakranya: " + chakra);
        } else {
            System.out.println("Mode Sage tidak aktif");
        }
    }
    public void gunakanRasengan() {
        if (chakra >= 20) {
            chakra -= 20;
            System.out.println("Rassssengggannnnn, sisa chakranya: " + chakra);
        } else {
            System.out.println("Chakra tidak cukup.");
        }
    }
    @Override
    public double hitungPajak() {
        return 0;
    }
    @Override
    public String getTipeKendaraan() {
        return "Shinobi";
    }
}
