public class KeretaApi extends Kendaraan implements IBergerak {
    private int jumlahGerbong;
    private String jenisRel;
    private boolean listrik;
    
    public KeretaApi(String merk, int tahunProduksi, int jumlahGerbong, String jenisRel, boolean listrik) {
        super(merk, tahunProduksi);
        this.jumlahGerbong = jumlahGerbong;
        this.jenisRel = jenisRel;
        this.listrik = listrik;
    }
    
    @Override
    public void info() {
        System.out.println("Kereta Api " + merk + " (" + tahunProduksi + ")");
        System.out.println("- Jumlah Gerbong: " + jumlahGerbong);
        System.out.println("- Jenis Rel: " + jenisRel);
        System.out.println("- Tenaga: " + (listrik ? "Listrik" : "Diesel"));
    }
    
    @Override
    public void maju() {
        System.out.println(merk + " melaju di rel " + jenisRel + " dengan " + jumlahGerbong + " gerbong");
    }
    
    @Override
    public void berhenti() {
        System.out.println(merk + " berhenti di stasiun");
    }
    
    // Method khusus
    public void bunyikanPeluit() {
        System.out.println("Tuuuut! Tuuuut!");
    }
    
    public void tambahGerbong(int tambahan) {
        jumlahGerbong += tambahan;
        System.out.println("Menambahkan " + tambahan + " gerbong, total sekarang: " + jumlahGerbong);
    }
}