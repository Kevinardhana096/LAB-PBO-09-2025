public class Wizard extends Hero {
    public Wizard(String name) {
        super(name, 100, 20);
    }

    @Override
    public void attack() {
        System.out.println("Penyihir menyerang dengan kekuatan " + attackPower + "!");
    }
}
