package learn.game;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GameController {

    private final String wordTheyGuess = "The Priest";
    ArrayList<String> correctLetters = new ArrayList<>();
    ArrayList<String> incorrectLetters = new ArrayList<>();
    Temp temp = new Temp(wordTheyGuess);

    @PutMapping("/guess/{letter}")
    public String guessLetter(@PathVariable String letter) {
        if (wordTheyGuess.toLowerCase().contains(letter.toLowerCase())) {
            correctLetters.add(letter.toLowerCase());
            temp.updateTemp(letter.toLowerCase(), wordTheyGuess);
        }
        else {
            incorrectLetters.add(letter.toLowerCase());
        }
        return temp.getTemp().toString();
    }

    @GetMapping("/word")
    public String getWord() {
        return temp.getTemp().toString();
    }


}
