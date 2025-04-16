import java.util.Scanner;

public class Task3 {
    public static void main(String[]Args){
        Scanner d = new Scanner (System.in);
        System.out.print("dd-mm-yy: ");
        String input = d.nextLine();

        String [] parts = input.split("-"); 
        int hari = Integer.parseInt(parts[0]);
        int bulan = Integer.parseInt(parts[1]);
        int tahun = Integer.parseInt(parts[2]);

        String[] namaBulan= {
          "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"  
        };
        int tahunlengkap = (tahun < 100)? 2000 + tahun :tahun;
        
        System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahunlengkap);
    d.close();
    }
}
