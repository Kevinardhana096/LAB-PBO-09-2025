public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Avanza", "mpv");
        mobil.setJumlahKursi(15);
        mobil.setKapasitasMesin(5);
        System.out.println(mobil.hitungPajak());
    }
}
