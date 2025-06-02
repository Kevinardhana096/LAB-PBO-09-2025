public class AlatInvestigasi {
    private String nama;
    private double efektivitas;
    
    public AlatInvestigasi(){
        String nama;
        double efektivitas;
    }

    public AlatInvestigasi(String nama, double efektivitas){
        this.nama = nama;
        this.efektivitas = efektivitas;
    }

    public String getNama(){
        return nama;
    }

    public double getEfektivitas(){
        return efektivitas;
    }
}
