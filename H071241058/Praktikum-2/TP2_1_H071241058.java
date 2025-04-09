public class TP2_1_H071241058 {
    String name;
    int age;
    boolean isMale;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Umur tidak boleh negatif!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public String getGender() {
        return isMale ? "Male" : "Female";
    }
    
    public static void main(String[] args) {
        TP2_1_H071241058 person = new TP2_1_H071241058();
        person.setName("ira");
        person.setAge(19);
        person.setGender(false);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());

    }
}