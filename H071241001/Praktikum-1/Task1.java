import java.util.Scanner;

public class Task1{
    public static void main (String []Args){
    Scanner x = new Scanner (System.in);
    System.out.print("Masukkan Judul Film: ");
    String judul = x.nextLine();

    String hasil = upper(judul);
    System.out.println(hasil);
    x.close();
}

public static String upper(String judul) {
    if (judul == null || judul.isEmpty()){
        return judul;
    }
    String[]kata = judul.split(" ");

    String hasil = "";
    for (String s : kata){
        if (s.length() > 0){
            hasil += s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase()+ " ";
        }
    }
    return hasil.trim();
}

}