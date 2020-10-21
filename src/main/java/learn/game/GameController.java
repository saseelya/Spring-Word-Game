package learn.game;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GameController {

    private final String wordTheyGuess = "The Priest";
    ArrayList<String> lettersGuessed = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    @PutMapping("/guess/{letter}")
    public String guessLetter(String letter) {
        for (int i = 0; i < wordTheyGuess.length(); i++) {
            if (wordTheyGuess.charAt(i) == ' ') {
                temp.append(" ");
            } else if (letter == (wordTheyGuess.charAt(i))){
                temp.append(wordTheyGuess.charAt(i));
            } else {
                temp.append("_");
            }
        }

        getWord();
        return "";
    }

    @GetMapping("/word")
    public String getWord() {


        return temp.toString();
    }


}
