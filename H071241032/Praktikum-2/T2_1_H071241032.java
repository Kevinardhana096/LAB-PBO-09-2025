public class t2n1 {
    String name;
    int age;
    boolean isMale;
    public void setName(String name){
        this.name =name;
    }
    public String getName(){
        return "Nama si doi :"+name;
    }
    public void setAge(int age){
        this.age =age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(boolean isMale){
        this.isMale=isMale;
    }
    public String getGender(){
        return "Jenis Kelamin: " + (isMale ? "Laki-laki" : "Perempuan");
    }
    
    public static void main(String[] args) {
        t2n1 data =new t2n1();
        data.setName("Didit");
        data.setAge(19);
        data.setGender(true);
        System.out.println(data.getName());
        System.out.println("Umur doi: " + data.getAge());
        System.out.println(data.getGender());
    }

}
