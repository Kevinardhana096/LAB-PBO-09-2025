import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan judul film: ");
        String judul = scanner.nextLine();

        System.out.println(UbahKapital(judul));

        scanner.close();
    }

    public static String UbahKapital(String teks) {
        String[] kata = teks.split("\\s+");
        StringBuilder hasil = new StringBuilder();

        for (String word : kata) {
            if (!word.isEmpty()) {
                hasil.append(Character.toUpperCase(word.charAt(0)))
                     .append(word.substring(1).toLowerCase())
                     .append(" ");
            }
        }

        return hasil.toString().trim();
    }
}