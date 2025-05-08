public class Main {
    public static void main(String[] args) {
        // 1. Buat objek masing-masing kendaraan
        Mobil mobil = new Mobil("Toyota Avanza", 2020, 5, "Bensin");
        Motor motor = new Motor("Honda Scoopy", 2021, true, 4);
        Sepeda sepeda = new Sepeda("Polygon", 2022, 6, "Cakram");
    

        // 2. Demo Mobil
        System.out.println("==== DEMO MOBIL ====");
        mobil.info();
        mobil.maju();
        mobil.berhenti();
        mobil.klakson();
        mobil.service(); // Panggil service langsung

        // 3. Demo Motor
        System.out.println("\n==== DEMO MOTOR ====");
        motor.info();
        motor.maju();
        motor.berhenti();
        motor.wheelie();
        if (motor.periksaKondisi()) { // Cek perlu service
            motor.service();
        }

        // 4. Demo Sepeda
        System.out.println("\n==== DEMO SEPEDA ====");
        sepeda.info();
        sepeda.maju();
        sepeda.berhenti();
        sepeda.bunyikanBel();
        sepeda.service();

        KeretaApi kereta = new KeretaApi("KA Harina", 2018, 8, "Standard", true);
        
        System.out.println("\n==== DEMO KERETA API ====");
        kereta.info();
        kereta.maju();
        kereta.berhenti();
        kereta.bunyikanPeluit();
        kereta.tambahGerbong(2);
    }

}