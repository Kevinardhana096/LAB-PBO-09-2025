import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        Scanner scanner = new Scanner(System.in);
        int angka = scanner.nextInt();

        String posisi = "";

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == angka) {
                    posisi = angka + " at " + "[" + i + "]" + "[" + j + "]";
                    break;
                }
            }
        }

        if (posisi.equals("")) {
            System.out.println(angka + " Tidak ditemukan");
        } else {
            System.out.println(posisi);
        }
        scanner.close();
    }
}
