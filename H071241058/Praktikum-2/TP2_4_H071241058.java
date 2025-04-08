class Alamat {
    String jalan;
    String kota;
}

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.jalan + ", " + alamat.kota;
    }
}

public class TP2_4_H071241058 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Inspeksi Kanal";
        alamat.kota = "Makassar";
        
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat; // Memasukkan objek alamat ke dalam mahasiswa
        mahasiswa.nama = "Ira";
        mahasiswa.nim = "H071241058";

        System.out.println("Nama   : " + mahasiswa.getNama());
        System.out.println("NIM    : " + mahasiswa.getNim());
        System.out.println("Alamat : " + mahasiswa.getAlamat());
    }
}
