package login_app.models;

public class Profile {
    //todo
    private String fullName;
    private String nickName;
    private int age;
    private String hobby;

    public Profile() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    } 
}
