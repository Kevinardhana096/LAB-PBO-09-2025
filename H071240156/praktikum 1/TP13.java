import java.util.Scanner;

public class TP13 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();

        String[] perbagian = input.split("-");

        if(perbagian.length != 3){
            System.out.println("Format tanggal tidak valid");
        } else {
            try{
                int tanggalInt = Integer.parseInt(perbagian[0]);
                if (tanggalInt<1||tanggalInt>31){
                    System.out.println("tanggal tidak valid");
                    return;
                }
                String tanggal = String.valueOf(tanggalInt);

                String bulan = konversiBulan(perbagian[1]);
                if (bulan.equals("Bulan Tidak Valid")){
                    System.out.println("Bulan tidak valid");
                    return;
                }
                int tahunInt = Integer.parseInt(perbagian[2]);
                String tahun = (tahunInt >=0 && tahunInt <= 49) ? "20" + perbagian[2] : "19" + perbagian[2];

                System.out.println("Output: "+tanggal+" "+bulan+" "+tahun);
            } catch (Exception e) {
                System.out.println("format angka tidak Valid");
            }
        }
        scanner.close();
    }

    public static String konversiBulan(String bulan){
        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        try {
            int bulanAngka = Integer.parseInt(bulan);
            if(bulanAngka >= 1 && bulanAngka <= 12){
                return namaBulan[bulanAngka-1];
            }
        } catch (Exception e) {
            return "Bulan tidak valid";
        }
        return "Bulan tidak valid";
    }
    
}
