package login_app.models;
public class User {
    private String username;
    private String password;
    private Profile profile;
    public String getUsername() { 
        return username; 
    } 
 
    public String getPassword() { 
        return password;
    } 
    public Profile getProfile(){
        return profile;
    }
    public User(String username, String password, Profile profile){
        this.username=username;
        this.password=password;
        this.profile=profile;
    }
}
