import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] array = {
            {9, 3, 7},
            {2, 5, 8},
            {6, 1, 4}
        };

        System.out.print("Masukkan angka yang ingin dicari: ");
        try {
            int target = scanner.nextInt();
            System.out.println(cariAngka(array, target));
        } catch (Exception e) {
            System.out.println("Input tidak valid");
        }

        scanner.close();
    }

    public static String cariAngka(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return "Found " + target + " at [" + i + "][" + j + "]"; // Format output yang diinginkan
                }
            }
        }
        return "Angka tidak ditemukan dalam array.";
    }
}
