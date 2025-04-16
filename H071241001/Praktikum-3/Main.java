public class Main {
    public static void main(String[] args) {
        Karakter player = new Karakter();
        Game game1 = new Game("Lempar Dart", 2, 1);
        Game game2 = new Game("Puzzle Logika", 3, 2);

        game1.info();
        game2.info();

        player.mainGame(game1);
        player.cekStatus();

        player.mainGame(game2);
        player.cekStatus();

        player.tukarPoin();
        player.cekStatus();
    }
}
