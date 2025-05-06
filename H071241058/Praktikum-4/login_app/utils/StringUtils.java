package login_app.utils;

public class StringUtils {
    //todo
    public static String generateNickName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "";
        }
    
        String[] parts = fullName.trim().split("\\s+");
        return parts[parts.length - 1];
    }
    
}
