public class Main {
    public static void main(String[] args) {
        Player player = new Player("Lulu Delu");
        Word word = new Word();
        Game game = new Game(player, word, 10);
        game.play();

    }
}