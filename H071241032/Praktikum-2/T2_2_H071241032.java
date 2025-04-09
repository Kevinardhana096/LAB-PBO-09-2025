public class t2n2 {
    int id;
    String nama;
    int stok;
    int harga;
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setNama(String nama){
        this.nama =nama;
    }
    public String getNama(){
        return "Nama produk: " +nama;
    }
    public void setHarga(int harga){
        this.harga=harga;
    }
    public int getHarga(){
        return harga;
    }
    public void setStok(int stok){
        this.stok=stok;
    }
    public String getStatusStok(){
        if(stok < 1){
            return "Kosong";
        }else{
            return "Tersedia";
        }
    }
    public static void main(String[] args) {
        t2n2 data = new t2n2();
        data.setNama("gitar garry");
        data.setId(999);
        data.setHarga(80_000_000);
        data.setStok(4);
        System.out.println("ID produk: "+data.getId());
        System.out.println(data.getNama());
        System.out.println("Harga produk: " +data.getHarga());
        System.out.println("Stok barang: "+data.stok +" "+"Ket: " +data.getStatusStok());

        
    }
}