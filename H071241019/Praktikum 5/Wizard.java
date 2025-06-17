class Wizard extends Hero {
    public Wizard(String name) {
        super(name, 80, 20);
    }

    @Override
    public void attack() {
        System.out.println(name + " melemparkan mantra dengan kekuatan " + attackPower);
    }
}