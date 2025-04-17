public class Pesawat {
    private String maskapai;
    private int kapasitasPenumpang;
    private Pilot pilot; 
   
    public Pesawat() {
        this.maskapai = "Tidak diketahui";
        this.kapasitasPenumpang = 0;
        this.pilot = new Pilot();
    }

    public Pesawat(String maskapai, int kapasitasPenumpang, Pilot pilot) {
        this.maskapai = maskapai;
        this.kapasitasPenumpang = kapasitasPenumpang;
        this.pilot = pilot;
    }

    public void terbangKe(String tujuan) {
        System.out.println("Pesawat " + maskapai + " diterbangkan oleh " + pilot.getNama() + " menuju " + tujuan + ".");
    }

    public void bandingkanKapasitas(Pesawat lain) {
        if (this.kapasitasPenumpang > lain.kapasitasPenumpang) {
            System.out.println(this.maskapai + " memiliki kapasitas lebih besar daripada " + lain.maskapai + ".");
        } else if (this.kapasitasPenumpang < lain.kapasitasPenumpang) {
            System.out.println(this.maskapai + " memiliki kapasitas lebih kecil daripada " + lain.maskapai + ".");
        } else {
            System.out.println("Kapasitas " + this.maskapai + " dan " + lain.maskapai + " sama.");
        }
    }

    public void infoPesawat() {
        System.out.println("Maskapai: " + maskapai);
        System.out.println("Kapasitas Penumpang: " + kapasitasPenumpang);
        pilot.tampilkanInfo();
    }
}
