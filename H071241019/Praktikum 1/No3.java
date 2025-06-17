import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();

        System.out.println(konversiTanggal(input));

        scanner.close();
    }

    public static String konversiTanggal(String tanggal) {
        String[] bulanNama = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                              "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        String[] bagian = tanggal.split("-");

        if (bagian.length != 3) {
            return "Format tanggal tidak valid.";
        }

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        tahun = (tahun < 50) ? 2000 + tahun : 1900 + tahun;

        if (bulan < 1 || bulan > 12) {
            return "Format bulan tidak valid.";
        }

        return hari + " " + bulanNama[bulan - 1] + " " + tahun;
    }
}