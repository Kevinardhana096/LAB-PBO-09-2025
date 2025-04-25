import java.util.ArrayList;

public class Perumahan {
    private ArrayList<Rumah> daftarRumah;
    private ArrayList<Keluarga> daftarKeluarga;
    private String namaPerumahan;
    private String alamatPerumahan;
    private int luasTanahTersedia;
    private int kapasitasMaxUnit;

    public Perumahan() {
        daftarRumah = new ArrayList<>();
        daftarKeluarga = new ArrayList<>();
    }

    public Perumahan(String nama, String alamat, int luasTanah, int kapasitasMax) {
        this.daftarRumah = new ArrayList<>();
        this.namaPerumahan = nama;
        this.alamatPerumahan = alamat;
        this.luasTanahTersedia = luasTanah;
        this.kapasitasMaxUnit = kapasitasMax;
        daftarRumah = new ArrayList<>();
        daftarKeluarga = new ArrayList<>();
    }

    public boolean cekNomorKKDipakai(String nomorKK) {
        for (Keluarga each : daftarKeluarga) {
            if (each.getNomorKK() == nomorKK) {
                return true;
            }
        }
        return false;
    }

    public void tambahKeluarga(Keluarga keluarga) {
        Boolean nomorKKDipakai = cekNomorKKDipakai(keluarga.getNomorKK());

        if (nomorKKDipakai) {
            System.out.println("Nomor Kartu Keluarga Telah Digunakan");
            return;
        }

        if ((daftarKeluarga.size() + 1) > daftarRumah.size()) {
            System.out.println("Rumah Tidak Tersedia Untuk Keluarga");
            return;
        }
        daftarKeluarga.add(keluarga);
    }

    public void beliRumah(Rumah rumah, Keluarga keluarga) {
        if (!daftarKeluarga.contains(keluarga)) {
            System.out.println("Keluarga Belum Terdaftar Pada Perumahan");
            return;
        }

        if (keluarga.kekayaanBersih < rumah.harga) {
            System.out.println("Kekayaan Bersih Tidak Mencukupi Untuk Membeli Rumah");
            return;
        }

        Boolean isRumahTersedia = rumah.status == Rumah.StatusRumah.TERSEDIA;

        if (isRumahTersedia) {
            keluarga.rumahHunian = rumah;
            rumah.setStatus(Rumah.StatusRumah.DITEMPATI);
            System.out.printf("Keluarga %s menempati rumah %s \n", keluarga.kepalaKeluarga, rumah.kode);
        } else {
            System.out.printf("Rumah %s tidak tersedia!, Status = %s", rumah.kode, rumah.status);
        }
    }

    public void bangunRumah(Rumah rumahBaru) {
        if (daftarRumah.size() >= kapasitasMaxUnit) {
            System.out.println("Error: Kapasitas perumahan penuh!");
            return;
        }

        if (rumahBaru.luasTanah > luasTanahTersedia) {
            System.out.println("Error: Luas tanah tidak mencukupi!");
            return;
        }

        daftarRumah.add(rumahBaru);
        luasTanahTersedia -= rumahBaru.luasTanah;
        System.out.println("Rumah berhasil ditambahkan!");
    }

    public int hitungLuasTerpakai() {
        int total = 0;
        for (Rumah rumah : daftarRumah) {
            total += rumah.luasTanah;
        }
        return total;
    }

    public void displayInfo() {
        System.out.println("Nama Perumahan : " + namaPerumahan);
        System.out.println("Alamat : " + alamatPerumahan);
        System.out.printf("Luas Tanah Tersedia : %s m2", luasTanahTersedia);
        System.out.printf("\nTotal Unit : %s/%s \n", daftarRumah.size(), kapasitasMaxUnit);
    }

    public void tampilkanDaftarKeluarga() {
        tulisJudul("Daftar Keluarga");

        if (daftarKeluarga.isEmpty()) {
            System.out.println("- Belum Ada Daftar Keluarga -");
            return;
        }

        int count = 1;
        for (Keluarga keluarga : daftarKeluarga) {
            if (count % 2 == 0) {
                System.out.println("===============");
            }
            System.out.println("Kepala Keluarga     : " + keluarga.kepalaKeluarga);
            System.out.println("Kekayaan Bersih : " + keluarga.kekayaanBersih);
            System.out.println("Anggota Keluarga    : ");
            for (String anggota : keluarga.anggotaKeluarga) {
                System.out.println("- " + anggota);
            }
            System.out.println("===============");
        }
    }

    public static void main(String[] args) {
        Perumahan tallasaCity = new Perumahan("Tallasa City", "Jl. Sudirman No. 88", 5000, 10);

        tulisJudul("Informasi Perumahan");
        tallasaCity.displayInfo();

        Rumah rumah1 = new Rumah("A101", 120_000_000, "Cluster Maple", 350, 200, Rumah.StatusRumah.TERSEDIA);
        Rumah rumah2 = new Rumah("A102", 150_000_000, "Cluster Oak", 450, 250, Rumah.StatusRumah.TERSEDIA);

        Keluarga keluargaJonas = new Keluarga("123", "Jonas", 250_000_000);
        keluargaJonas.tambahAnggota("Sofi");
        keluargaJonas.tambahAnggota("Adit");
        Keluarga keluargaSarham = new Keluarga("321", "Sarham", 100_000_000);
        keluargaSarham.tambahAnggota("Ica");

        System.out.println();
        tallasaCity.bangunRumah(rumah1);
        tallasaCity.bangunRumah(rumah2);

        tallasaCity.tambahKeluarga(keluargaJonas);
        tallasaCity.tambahKeluarga(keluargaSarham);

        tallasaCity.beliRumah(rumah1, keluargaJonas);
        tallasaCity.beliRumah(rumah1, keluargaSarham);
        tallasaCity.beliRumah(rumah2, keluargaSarham);

        keluargaSarham.displayInfo();

        tallasaCity.tampilkanDaftarKeluarga();
    }

    public static void tulisJudul(String judul) {
        System.out.printf("\n=== %s ===\n", judul);
    }
}
