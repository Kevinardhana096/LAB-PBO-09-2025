public class Main {
    public static void main(String[] args) {
        Mafia mafia1 = new Mafia("Don Vito", "Beretta", 9, 12.5, "Fedora", "Rompi Anti Peluru");
        Mafia mafia2 = new Mafia("Tony Montana", "Desert Eagle", 12, 13.2, "Topi Hitam", "Jas Hitam");

        mafia1.checkStatus();
        pembatas();

        mafia2.checkStatus();
        pembatas();

        mafia1.shoot(mafia2);
        mafia2.checkStatus();
        pembatas();
        mafia1.checkStatus();
        pembatas();

        mafia1.senjata.damageTembakan = 45;
        mafia2.senjata.damageTembakan = 40;

        mafia2.shoot(mafia1);
        mafia2.checkStatus();
        pembatas();
        mafia1.checkStatus();
        pembatas();

        mafia1.shoot(mafia2);
        mafia2.checkStatus();
        pembatas();
        mafia1.checkStatus();
        pembatas();
    }

    public static void pembatas() {
        System.out.println("========================================");
    }
}
