public class Fighter extends Hero {
    public Fighter(String name) {
        this(name, 100, 18);
    }

    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println("Fightrer menyerang dengan kekuatan " + attackPower + "!");
    }

}
