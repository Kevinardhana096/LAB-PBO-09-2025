public class Kasus {
    private String nama;
    private String tingkatKesulitan;
    private double progres;
    private Detektif penyelidik;

    public Kasus(String nama, String tingkatKesulitan, double progres, Detektif penyelidik){
        this.nama = nama;
        this.tingkatKesulitan = tingkatKesulitan;
        this.progres = 0;
        this.penyelidik = penyelidik;
    }

    public void setProgres(double nilai){
        progres += nilai;
        if (progres > 100){
            progres = 100;
        }
    }

    public double getMinimumProgres(){
        if (tingkatKesulitan.equalsIgnoreCase("mudah")){
            return 40;
        } else if (tingkatKesulitan.equalsIgnoreCase("sedang")){
            return 60;
        } else {
            return 100;
        }
    }

    public void tampilkanStatus(){
        System.out.println("Kasus: "+nama);
        System.out.println("Tingkat Kesulitan: "+tingkatKesulitan);
        System.out.println("Penyelidik: "+penyelidik.getNama()+" ("+penyelidik.getTingkat()+" )");
        System.out.println("Progres Penyelesaian: "+progres+"%");

        if (progres >= getMinimumProgres()){
            System.out.println("STATUS: KASUS TERPECAHKAN");
        } else {
            System.out.println("STATUS: KASUS TIDAK TERPECAHKAN");
        }
    }

    public void bandingkanDengan(Kasus lain){
        System.out.println("Membandingkan progres dengan kasus: "+lain.nama);
    if (this.progres > lain.progres){
        System.out.println("Kasus -"+this.nama+"- lebih cepat progresnya");
    } else if (this.progres < lain.progres){
        System.out.println("Kasus -"+lain.nama+"- lebih cepat progresnya");
    } else {
        System.out.println("Kedua kasus memiliki progres yang sama");
    }
    }
}
