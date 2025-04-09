public class NO1 {
    private String name;
    private int age;
    private boolean isMale;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setGender(boolean isMale){
        this.isMale = isMale;
    }
    public String getGender(){
        return this.isMale ? "Male" : "Female"; //ternary
    }

    public static void main(String[] args) {
        NO1 p = new NO1();

        p.setName("stecu");
        p.setAge(20);
        p.setGender(true);

        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Gender: " + p.getGender());

    }
}