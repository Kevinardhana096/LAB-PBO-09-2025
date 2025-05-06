package login_app.models;
public class Profile {
    private String fullname;
    private int umur;
    private String hobi;
    private String nickname;
    public Profile(String fullname, int umur,String hobi,String nickname){
        this.fullname=fullname;
        setUmur(umur);
        this.hobi=hobi;
        this.nickname=nickname;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public int getUmur() {
        if (umur > 0) {
            return umur;
        } else {
            throw new IllegalArgumentException("Umur harus lebih dari 0");
        }
    }
    public void setUmur(int umur) {
        if (umur > 0) {
            this.umur = umur;
        } else {
            throw new IllegalArgumentException("Umur tidak valid. Umur harus lebih dari 0.");
        }
    }
    public String getHobi() {
        return hobi;
    }
    public void setHobi(String hobi) {
        this.hobi = hobi;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    

}
