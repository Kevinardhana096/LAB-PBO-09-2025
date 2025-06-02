import java.util.Random;
import java.util.Scanner;

public class TP12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Membuat array 2D dengan angka acak (3x3)
        int[][] nums = new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = random.nextInt(10); // Angka acak 0-9
            }
        }

        // Menampilkan array
        System.out.println("Array 2D:");
        for (int[] row : nums) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        try {
            // Meminta input pengguna
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            // Mencari angka dalam array
            boolean ditemukan = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; // Hentikan pencarian setelah ditemukan
                    }
                }
                if (ditemukan) break; // Keluar dari loop luar jika sudah ditemukan
            }

            // Jika angka tidak ditemukan
            if (!ditemukan) {
                System.out.println(target + " tidak ditemukan dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat!");
        } finally {
            scanner.close();
        }
    }
}
