import java.util.Scanner;

public class TP14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input: ");
        int input = scanner.nextInt();
        
        if(input < 0){
            System.out.println("Faktorial tidak boleh negatif");
        } else {
            System.out.println(faktorial(input));
        }
        scanner.close();
    }
    public static long faktorial(int input) {
        if(input==1||input==0){
            return 1;
        } 
        return input * faktorial(input-1);
    }
}


/*
 5 x 4!(24) = 120
 4 x 3! (6) = 24
 3 x 2!(2) = 6 
 2 x 1!(1) = 2
 1! = 1
 */