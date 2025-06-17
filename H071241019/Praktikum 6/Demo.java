import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM INPUT KENDARAAN ===");
        System.out.println("Pilih jenis kendaraan yang ingin diinput:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("3. Sepeda");
        System.out.println("4. Boat");
        System.out.print("Masukkan pilihan (1-4): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline

        switch (pilihan) {
            case 1:
                inputMobil(scanner);
                break;
            case 2:
                inputMotor(scanner);
                break;
            case 3:
                inputSepeda(scanner);
                break;
            case 4:
                inputBoat(scanner);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }

    private static void inputMobil(Scanner scanner) {
        System.out.println("\n=== Input Data Mobil ===");
        System.out.print("Merek: ");
        String merek = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        Mobil mobil = new Mobil(merek, model);

        System.out.print("Kapasitas Mesin (cc): ");
        mobil.setKapasitasMesin(scanner.nextDouble());

        System.out.print("Jumlah Pintu: ");
        mobil.setJumlahPintu(scanner.nextInt());

        System.out.print("Jumlah Kursi: ");
        mobil.setJumlahKursi(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Bahan Bakar: ");
        mobil.setBahanBakar(scanner.nextLine());

        System.out.print("Tahun Produksi: ");
        mobil.setTahunProduksi(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Warna: ");
        mobil.setWarna(scanner.nextLine());

        tampilkanInfoKendaraan(mobil);
    }

    private static void inputMotor(Scanner scanner) {
        System.out.println("\n=== Input Data Motor ===");
        System.out.print("Merek: ");
        String merek = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        Motor motor = new Motor(merek, model);

        System.out.print("Jenis Motor: ");
        motor.setJenisMotor(scanner.nextLine());

        System.out.print("Kapasitas Tangki (liter): ");
        motor.setKapasitasTangki(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Tipe Suspensi: ");
        motor.setTipeSuspensi(scanner.nextLine());

        System.out.print("Tahun Produksi: ");
        motor.setTahunProduksi(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Warna: ");
        motor.setWarna(scanner.nextLine());

        tampilkanInfoKendaraan(motor);
    }

    private static void inputSepeda(Scanner scanner) {
        System.out.println("\n=== Input Data Sepeda ===");
        System.out.print("Merek: ");
        String merek = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        Sepeda sepeda = new Sepeda(merek, model);

        System.out.print("Jenis Sepeda: ");
        sepeda.setJenisSepeda(scanner.nextLine());

        System.out.print("Jumlah Gear: ");
        sepeda.setJumlahGear(scanner.nextInt());

        System.out.print("Ukuran Roda (inci): ");
        sepeda.setUkuranRoda(scanner.nextInt());

        System.out.print("Tahun Produksi: ");
        sepeda.setTahunProduksi(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Warna: ");
        sepeda.setWarna(scanner.nextLine());

        tampilkanInfoKendaraan(sepeda);
    }

    private static void inputBoat(Scanner scanner) {
        System.out.println("\n=== Input Data Boat ===");
        System.out.print("Merek: ");
        String merek = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        Boat boat = new Boat(merek, model);

        System.out.print("Jenis Perahu: ");
        boat.setJenisPerahui(scanner.nextLine());

        System.out.print("Daya Mesin (hp): ");
        boat.setDayaMesin(scanner.nextDouble());

        System.out.print("Tahun Produksi: ");
        boat.setTahunProduksi(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Warna: ");
        boat.setWarna(scanner.nextLine());

        tampilkanInfoKendaraan(boat);
    }

    private static void tampilkanInfoKendaraan(Kendaraan k) {
        System.out.println("\n=== INFORMASI KENDARAAN ===");
        System.out.println("ID: " + k.getId());
        System.out.println("Merek: " + k.getMerek());
        System.out.println("Model: " + k.getModel());
        System.out.println("Tipe: " + k.getTipeKendaraan());
        System.out.println("Tahun Produksi: " + k.getTahunProduksi());
        System.out.println("Warna: " + k.getWarna());
        System.out.println("Pajak: Rp" + k.hitungPajak());

        if (k instanceof iServiceable) {
            iServiceable s = (iServiceable) k;
            System.out.println("Biaya Servis: Rp" + s.hitungBiayaServis());
        }
    }
}
