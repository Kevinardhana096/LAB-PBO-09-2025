public class Rumah {
    public enum StatusRumah {
        TERSEDIA, DITEMPATI,
    }

    String kode;
    double harga;
    StatusRumah status;
    String alamat;
    int luasTanah;
    int luasBangunan;
    String tipeProperti;
    boolean memilikiGarasi;
    boolean memilikiTaman;

    public void setStatus(StatusRumah status) {
        this.status = status;
    }

    public Rumah(String kode, double harga, String alamat, int luasTanah, int luasBangunan, StatusRumah status) {
        this.kode = kode;
        this.harga = harga;
        this.alamat = alamat;
        this.luasTanah = luasTanah;
        this.luasBangunan = luasBangunan;
        setStatus(status);
    }

    public void displayInfo() {
        System.out.println("Kode : " + kode);
        System.out.println("Alamat : " + alamat);
        System.out.printf("Luas Tanah : %s m2\n", luasTanah);
        System.out.printf("Luas Bangunan : %s m2\n", luasBangunan);
        System.out.printf("Harga : Rp%s\n", harga);
        System.out.println("Status : " + status);
    }

}