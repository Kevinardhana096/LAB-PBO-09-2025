import java.util.Scanner;


public class Task2 {
    public static void main (String[] Args){
        Scanner m = new Scanner (System.in);
        System.out.print("Masukkan angka:");

        try {
            int input = m.nextInt();
            int [][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            boolean found = false;

            for (int i = 0; i <nums.length; i++){
                for(int j = 0; j <nums[i].length; j++){
                    if (nums[i][j]==input) {
                        System.out.println("Found " + input + " at [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }
                }
                if (found)break;
            }
            if(!found){
                System.out.println("angka " + input + " tidak ditemukan dalam array.");
            }
        } catch (Exception e){
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
        }
        m.close();
    }
}
