import java.util.Scanner;

public class TP11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();

        String lower=String.valueOf(input).toLowerCase();

        String[] arr=lower.split(" ");
        
        System.out.print("Hasil: ");
        for(int i=0;i<arr.length;i++){
            char c=arr[i].charAt(0);
            String c1=String.valueOf(c).toUpperCase();

            String sub=arr[i].substring(1);

            System.out.print(c1+sub+" ");
        }
        scanner.close();
    }
}
