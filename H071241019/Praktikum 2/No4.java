public class No4 {
public static void main(String[] args) {
    Alamat alamat = new Alamat();
    alamat.jalan = "Paccinang Raya";
    alamat.kota = "Makassar";

    Mahasiswa m = new Mahasiswa();
    m.nama = "Ishmah";
    m.nim = "H071241019";
    m.alamat = alamat;

    
        System.out.println("Nama    : " + m.getNama());
        System.out.println("NIM     : " + m.getNim());
        System.out.println("Alamat : " + m.getAlamat());
    }
}

class Alamat{
    String jalan;
    String kota; 

    String tampilAlamat(){
        return jalan + kota;

    }
}

class Mahasiswa{
    String nama;
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    String nim;
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    Alamat alamat;
    public String getAlamat() {
        return alamat.jalan + "," + alamat.kota;
    } 
}