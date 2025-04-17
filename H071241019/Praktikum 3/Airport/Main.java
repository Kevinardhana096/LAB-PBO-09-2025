public class Main {
    public static void main(String[] args) {
        Pilot pilot1 = new Pilot();
        Pilot pilot2 = new Pilot();

        pilot1.setNama("Chicko");
        pilot1.setUmur(21);
        pilot1.setJamTerbang(1200);

        Pesawat pesawat1 = new Pesawat("Garuda Indonesia", 180, pilot1);
        Pesawat pesawat2 = new Pesawat("Citilink", 150, pilot2);

        pesawat1.terbangKe("Jakarta");
        pesawat2.terbangKe("Surabaya");

        System.out.println();
        pesawat1.bandingkanKapasitas(pesawat2);

        System.out.println();
        pesawat1.infoPesawat();
        System.out.println();
        pesawat2.infoPesawat();
    }
}