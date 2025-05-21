
import java.util.Date;
public class Mobil extends Kendaraan implements IBergerak, IServiceable{
    private int jumlahpintu;
    private double kapasitasmesin;
    private int jumlahkursi;
    private String bahanbakar;
    private double kecepatan;
    public Mobil(String merek, String model) {
        super(merek, model);
    }
    public int getJumlahpintu() {
        return jumlahpintu;
    }
    public void setJumlahpintu(int jumlahpintu) {
        this.jumlahpintu = jumlahpintu;
    }
    public double getKapasitasmesin() {
        return kapasitasmesin;
    }
    public void setKapasitasmesin(double kapasitasmesin) {
        this.kapasitasmesin = kapasitasmesin;
    }
    public int getJumlahkursi() {
        return jumlahkursi;
    }
    public void setJumlahkursi(int jumlahkursi) {
        this.jumlahkursi = jumlahkursi;
    }
    public String getBahanbakar() {
        return bahanbakar;
    }
    public void setBahanbakar(String bahanbakar) {
        this.bahanbakar = bahanbakar;
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
    public double getKecepatan(){
        return kecepatan;
    }
    @Override
    public void setKecepatan(double kecepatan){
        this.kecepatan=kecepatan;
    }
    @Override
    public boolean periksaKondisi(){
        return true;
    }
    @Override 
    public void lakukanServis(){
        System.out.println("Otw spek GTR3000");
    }
    @Override
    public Date getWaktuservisberikutnya(){
        return new Date();
    }
    @Override
    public double hitungBiayaServis(){
        return 80_000_000;
    }
    @Override
    public double hitungPajak(){
        return kapasitasmesin * 1_000_000;
    }
    @Override
    public String getTipeKendaraan(){
        return "Mobil";
    }

}