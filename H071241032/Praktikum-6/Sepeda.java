import java.util.Date;
public class Sepeda extends Kendaraan implements IBergerak, IServiceable{
    private String jenissepeda;
    private int jumlahgear;
    private int ukuranroda;
    private double kecepatan;
    public Sepeda(String merek, String model){
        super(merek,model);
    }
    public String getJenissepeda() {
        return jenissepeda;
    }
    public void setJenissepeda(String jenissepeda) {
        this.jenissepeda = jenissepeda;
    }
    public int getJumlahgear() {
        return jumlahgear;
    }
    public void setJumlahgear(int jumlahgear) {
        this.jumlahgear = jumlahgear;
    }
    public int getUkuranroda() {
        return ukuranroda;
    }
    public void setUkuranroda(int ukuranroda) {
        this.ukuranroda = ukuranroda;
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
        System.out.println("Otw spek Tok Dalang Ranggi (TDR3000)");
    }
    @Override
    public Date getWaktuservisberikutnya(){
        return new Date();
    }
    @Override
    public double hitungBiayaServis(){
        return 10_000_000;
    }
    @Override
    public double hitungPajak(){
        return 0;
    }
    @Override
    public String getTipeKendaraan(){
        return "Sepeda";
    }
    
}