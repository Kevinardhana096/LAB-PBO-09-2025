package T3_1_H071241032;
import java.util.Scanner;
public class Bapakkost {
    String nama;
    int hargaKost;
    boolean kamarTersedia;
    PenyewaKost penyewa;
    public Bapakkost() {
        this.nama = "Didit";
        this.hargaKost = 1200000;
        this.kamarTersedia = true;
        this.penyewa = new PenyewaKost();
    }
    public Bapakkost(String nama, int hargaKost, boolean kamarTersedia, PenyewaKost penyewa) {
        this.nama = nama;
        this.hargaKost = hargaKost;
        this.kamarTersedia = kamarTersedia;
        this.penyewa = penyewa;
    }
    
    public void prosesSewa(PenyewaKost penyewa) {
        Scanner input = new Scanner(System.in);
        System.out.print("BapakKost - Apakah kamar ada yang kosong? (ya/tidak): ");
        String jawaban = input.nextLine().toLowerCase();
        if(jawaban.equals("tidak") && jawaban.equals("t")){
            System.out.println("Maaf, Penuh semua mi dek");
            return;
        }
    
        System.out.println(">> Proses sewa oleh " + nama + " untuk " + penyewa.nama);
    
        boolean berhasil = penyewa.inginSewa(hargaKost);
        if (berhasil) {
            System.out.println("Selamat datang di kost " + penyewa.nama );
            System.out.println("=== ATURAN DALAM KOST ===");
            System.out.println("- Kalau pulang diatas jam 12 malam dikuncikan, TIDUR DILUAR");
            System.out.println("- Tanggal 1 itu bayar kost, KALAU TIDAK : DIBUANG BARANG BARANG TA");
            System.out.println("- Utamakan jaga kebersihan");
            kamarTersedia = false;
        } else {
            System.out.println("Carimiki kost lain ya dek");
        }
    }
}
