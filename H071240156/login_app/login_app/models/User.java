package login_app.models;

public class User {
    private String userName;

    public String getUsername() {
        return userName;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}