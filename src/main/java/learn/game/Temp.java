package learn.game;

public class Temp {

    public StringBuilder temp = new StringBuilder();

    public Temp(String wordTheyGuess) {
        for (int i = 0; i < wordTheyGuess.length(); i++) {
            if (wordTheyGuess.charAt(i) == ' ') {
                temp.append(" ");
            }
            else {
                temp.append("-");
            }
        }
    }

    public StringBuilder getTemp() {
        return temp;
    }

    public void updateTemp(String guessedLetter, String wordTheyGuess) {
        for (int i = 0; i < temp.length(); i++) {
            if (wordTheyGuess.toLowerCase().charAt(i) == guessedLetter.charAt(0)) {
                temp.replace(i, i + 1, wordTheyGuess.substring(i, i + 1));
            }
        }
    }
}
