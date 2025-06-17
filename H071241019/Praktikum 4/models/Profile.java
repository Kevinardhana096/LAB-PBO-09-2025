package models;

public class Profile {
    private String nickname;
    private String name;
    private int age;
    private String hobby;
    
    public Profile(String nickname, String name, int age, String hobby) {
        this.nickname = nickname;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public Profile() {
    
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}