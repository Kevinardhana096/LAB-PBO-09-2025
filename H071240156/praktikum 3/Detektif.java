public class Detektif {
    private String nama;
    private String tingkat;
    private double efektivitas;

    public Detektif(String nama, String tingkat){
        this.nama = nama;
        this.tingkat = tingkat;
        if (tingkat.equalsIgnoreCase("senior")){
            this.efektivitas = 30;
        } else if (tingkat.equalsIgnoreCase("madya")){
            this.efektivitas = 20;
        } else if (tingkat.equalsIgnoreCase("junior")){
            this.efektivitas = 20;
        } else {
            this.efektivitas = 10;
        }
    }

    public String getNama(){
        return nama;
    }
    public String getTingkat(){
        return tingkat;
    }

    public double getEfektivitas(){
        return efektivitas;
    }
}
