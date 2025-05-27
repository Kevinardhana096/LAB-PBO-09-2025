package login_app.StringUtils;
public class StringUtils {
    public static String getNickName(String fullName) {
        String[] cek = fullName.trim().split(" ");
        if (cek.length == 1) {
            return cek[0];
        } else {
            return cek[1];
        }
    }
}
