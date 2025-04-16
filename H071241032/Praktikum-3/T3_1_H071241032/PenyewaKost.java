package T3_1_H071241032;
public class PenyewaKost {
    String nama;
    int umur;
    int uang;
    boolean sewaKost;
    boolean lakiLaki;
    public PenyewaKost() {
        this.nama=null;
        this.umur=0;
        this.uang=0;
        this.sewaKost=false;
        this.lakiLaki = true;
    }
    public PenyewaKost(String nama, int umur, int uang, boolean lakiLaki) {
        this.nama = nama;
        this.umur = umur;
        this.uang = uang;
        this.sewaKost = false;
        this.lakiLaki = lakiLaki;
    }
    public boolean inginSewa(int harga) {
        System.out.println(nama + " ingin menyewa kost.");

        if (umur < 18) {
            System.out.println("Maaf " + nama + ", minimal umur 18 tahun untuk ngekost.");
            return false;
        }

        if (!lakiLaki) {
            System.out.println("Maaf " + nama + ", kost ini khusus laki-laki.");
            return false;
        }

        if (uang >= harga) {
            System.out.println("Uang cukup. Proses sewa bisa dilanjutkan.");
            sewaKost = true;
            return true;
        } else {
            System.out.println("Maaf " + nama + ", uangmu belum cukup.");
            return false;
        }
    }
}
