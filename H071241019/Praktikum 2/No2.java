public class No2 {
    String id;
    String nama;
    int stok;
    double harga;

    void tampilProduk() {
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Stok   : " + stok);
        System.out.println("Harga  : Rp" + harga);
        System.out.println("Tersedia: " + (tersedia() ? "Ya" : "Tidak"));
    }

    boolean tersedia() {
        return stok > 0;
    }

    public static void main(String[] args) {
        No2 produk = new No2();
        produk.id = "P251";
        produk.nama = "PS 5";
        produk.stok = 0;
        produk.harga = 8687000;
        produk.tampilProduk();
    }
}