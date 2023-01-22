public class Attempts {
    private int maxErrorsAllowed;
    private int errorsCommitted;
    private String[] hangman;
    private String hiddenWord;

    public Attempts(int maxErrorsAllowed, String hiddenWord) {
        this.maxErrorsAllowed = maxErrorsAllowed;
        this.errorsCommitted = 0;
        this.hiddenWord = hiddenWord;
        hangman = new String[]{
                "",
                "",
                "",
                "",
                "",
                ""
        };
    }

    public boolean checkError(String letter) {
        if (!hiddenWord.contains(letter)) {
            errorsCommitted++;
            updateHangman();
            return true;
        }
        return false;
    }

    public boolean isLost() {
        return errorsCommitted >= maxErrorsAllowed;
    }

    public boolean isRight() {
        return !hiddenWord.contains("_");
    }
    private void updateHangman() {
        switch (errorsCommitted) {
            case 1:
                hangman[0] = " O ";
                hangman[1] = " | ";
                hangman[2] = " | ";
                break;
            case 2:
                hangman[3] = " | ";
                break;
            case 3:
                hangman[4] = " | ";
                break;
            case 4:
                hangman[4] = " | ";
                hangman[5] = " | ";
                break;
            case 5:
                hangman[5] = " | ";
                hangman[6] = "---";
                break;
            case 6:
                hangman[7] = " | ";
                break;
            case 7:
                hangman[8] = " | ";
                hangman[9] = " | ";
                break;
            case 8:
                hangman[9] = " | ";
                hangman[10] = " | ";
                break;
            case 9:
                hangman[11] = " | ";
                break;
            case 10:
                hangman[12] = " | ";
                hangman[13] = "---";
                break;
            default:
                break;
        }
    }

    public void showHangman() {
        for (String row : hangman) {
            System.out.println(row);
        }
    }

    public int getErrorsCommitted() {
        return errorsCommitted;
    }
}



