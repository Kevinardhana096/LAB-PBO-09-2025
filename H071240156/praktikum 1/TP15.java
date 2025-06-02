import java.util.Scanner;

public class TP15 {
        public static boolean cekpas(String pass) {
            if(pass.length()<8){
                return false;
            } 
    
            boolean hurufBesar = false;
            boolean hurufKecil = false;
            boolean angka = false;
    
            for(char i : pass.toCharArray()){
                if(Character.isUpperCase(i)){
                    hurufBesar =  true;
                } else if (Character.isLowerCase(i)){
                    hurufKecil =  true;
                } else if (Character.isDigit(i)){
                    angka =  true;
                }
            }
            return hurufBesar&&hurufKecil&&angka;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Password: ");
        String pass = scanner.nextLine();

        if (cekpas(pass)){
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        scanner.close();
    }    
}
