import java.util.Scanner;

public class Game {
    private Player player;
    private Word word;
    private Attempts attempts;
    private int maxAttemps;

    public Game(Player player, Word word, int maxAttemps) {
        this.player = player;
        this.word = word;
        this.attempts = new Attempts(maxAttemps, word.getHiddenWord());
        this.maxAttemps = maxAttemps;
    }

    public void play() {
        while (!attempts.isLost() && !attempts.isRight()) {
            System.out.println("Player: " + player.getName());
            System.out.println("Word to find: " + word.getWordToFind());
            System.out.println("Attempts remaining: " + (maxAttemps - attempts.getErrorsCommitted()));
            System.out.print("Enter a letter: ");

            Scanner sc = new Scanner(System.in);
            String letter = sc.nextLine();

            if (attempts.checkError(letter)) {
                System.out.println("Wrong letter!");
                attempts.showHangman();
            } else {
                word.decryptLetter(letter);
                System.out.println("Correct letter!");
            }

            System.out.println();
        }

        if (attempts.isLost()) {
            System.out.println("You lost the game!");
        } else {
            System.out.println("You won the game!");
        }
    }
}
