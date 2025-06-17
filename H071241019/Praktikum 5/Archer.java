class Archer extends Hero {
    public Archer(String name) {
        super(name, 100, 15);
    }

    @Override
    public void attack() {
        System.out.println(name + " menembakkan panah dengan kekuatan " + attackPower);
    }
}