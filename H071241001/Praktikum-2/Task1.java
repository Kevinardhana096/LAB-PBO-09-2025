public class Task1{
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Kak Kevin");
        person.setAge(20);
        person.setGender("Male");

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());


    }
}

class Person{
    String name;
    int age;
    boolean isMale;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(String gender){
        if (gender == "Male") {
            this.isMale = true;
        }
        else{
            this.isMale = false;
        }
    }
    public String getGender(){
        return isMale ? "Male" : "Female";

    }
}

