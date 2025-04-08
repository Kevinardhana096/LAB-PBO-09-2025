public class Task2 {
    public static void main(String[] args) {
        Produk produk = new Produk ();
        produk.produk("P001", "Produk A", 0, 25000);
        produk.setID("P001");
        produk.setnama("Produk 1");
        produk.setstok(0);
        produk.setharga(25000);
        
        produk.displayInfo();
    
        if (produk.isAvailable()) {
            System.out.println("Produk tersedia di stok.");
        } else {
            System.out.println("Produk tidak tersedia di stok.");
        }
    }
}

class Produk{
    String ID;
    String nama;
    int stok;
    double harga;

    public void produk(String ID, String nama, int stok, double harga){
    this.ID = ID;
    this.nama = nama;
    this.stok = stok;
    this.harga = harga;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getID (){
        return ID;
    }
    public void setnama(String nama){
        this.nama = nama;
    }
    public String getnama(){
        return nama;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    public int getstok(){
        return stok;
    }
    public void setharga(double harga){
        this.harga = harga;
    }
    public double getharga(){
        return  harga;
    }
    public void setstok(int stok){
        this.stok=stok;
    }
    public boolean isAvailable(){
        return stok >0;
    }
    public void displayInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: " + harga);
        System.out.println("Tersedia: " + (isAvailable() ? "Ya" : "Tidak"));
    }
}
