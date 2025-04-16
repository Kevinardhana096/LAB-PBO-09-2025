class Produk {
    String id, nama;
    int harga, stok;

    public String cekStok() {
        if (stok > 0) {
            return nama + " Tersedia, stok : " + stok;
        } else {
            return nama + " Tidak Tersedia";
        }
    }

    public void cekData() {
        System.out.println("==============");
        System.out.println("ID : " + id);
        System.out.println("Nama : " + nama);
        System.out.println("Harga : " + harga);
        System.out.println("Stok : " + stok);
        System.out.println("==============");
    }
}

public class No2 {
    public static void main(String[] args) {
        Produk produk = new Produk();

        produk.id = "1";
        produk.nama = "Gelas";
        produk.harga = 5000;
        produk.stok = 0;

        System.out.println();
        System.out.println("Detail Produk");

        produk.cekData();

        System.out.println();

        System.out.println(produk.cekStok());

    }
}
