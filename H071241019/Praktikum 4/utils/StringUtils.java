package utils;

public class StringUtils {

    public static String MadeNickame(String fullName){
        String[] jumlah = fullName.split("\\s+");
        int hasil = jumlah.length;
        if (hasil == 1){
            return fullName;
        }else {
            return jumlah[1];
        }
    }
}