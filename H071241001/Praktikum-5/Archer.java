public class Archer extends Hero{
    public Archer(String name, int health, int attackPower){
        super(name, health, attackPower);
    }
    public void attack() {
        System.out.println(name + " menembakkan panah dengan kekuatan " + attackPower);
    }
    
}
