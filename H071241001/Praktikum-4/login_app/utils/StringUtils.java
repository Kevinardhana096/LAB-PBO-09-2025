package login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName){
        String [] nameParts = fullName.split(" ");
        if (nameParts.length == 1){
            return fullName;
        } else {
            return nameParts[1];
        }
    }
}