
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak,IServiceable {
    private String jenismotor;
    private double kapasitastangki;
    private String tipesuspensi;
    private double kecepatan;
    public Motor(String merek, String model){
        super(merek, model);
    }
    public String getJenismotor() {
        return jenismotor;
    }
    public void setJenismotor(String jenismotor) {
        this.jenismotor = jenismotor;
    }
    public double getKapasitastangki() {
        return kapasitastangki;
    }
    public void setKapasitastangki(double kapasitastangki) {
        this.kapasitastangki = kapasitastangki;
    }
    public String getTipesuspensi() {
        return tipesuspensi;
    }
    public void setTipesuspensi(String tipesuspensi) {
        this.tipesuspensi = tipesuspensi;
    }
    @Override
    public boolean mulai(){
        return true;
    }
    @Override
    public boolean berhenti(){
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
    @Override
    public boolean periksaKondisi(){
        return true;
    }
    @Override
    public void lakukanServis(){
        System.out.println("Otw spek Ninja H2R");
    }
    @Override
    public Date getWaktuservisberikutnya(){
        return new Date();
    }
    @Override
    public double hitungBiayaServis(){
        return 5_000_000;
    }
    @Override
    public double hitungPajak(){
        return kapasitastangki * 500_000;
    }
    @Override
    public String getTipeKendaraan(){
        return "Motor";
    }

}
