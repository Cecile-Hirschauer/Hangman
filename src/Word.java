import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private String wordToFind;
    private String hiddenWord;
    private List<String> words;

    public Word() {
        try {
            words = new ArrayList<>();
            File file = new File("words.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
            sc.close();
            getRandomWord();
            hiddeWord();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getRandomWord() {
        Random rand = new Random();
        int index = rand.nextInt(words.size());
        wordToFind = words.get(index);
    }

    private void hiddeWord() {
        hiddenWord = wordToFind.replaceAll("[a-zA-Z]", "_");
    }

    public String getWordToFind() {
        return wordToFind;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    
        public void decryptLetter(String letter) {
            if (wordToFind.contains(letter)) {
                for (int i = 0; i < wordToFind.length(); i++) {
                    if (wordToFind.charAt(i) == letter.charAt(0)) {
                        char[] encryptedChar = wordToFind.toCharArray();
                        encryptedChar[i] = letter.charAt(0);
                        hiddenWord = String.valueOf(encryptedChar);
                    }
                }
            }

        }
    

}
