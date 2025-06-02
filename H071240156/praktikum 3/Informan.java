public class Informan {
    private String nama;
    private String deskripsi;
    private double efektivitas;

    public Informan(String nama, String deskripsi, double efektivitas){
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.efektivitas = efektivitas;
    }

    public String getNama(){
        return nama;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public double getEfektivitas(){
        return efektivitas;
    }
    
}
