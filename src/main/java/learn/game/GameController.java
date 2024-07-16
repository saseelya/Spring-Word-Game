package learn.game;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GameController {

    private final String wordTheyGuess = "Saltine SparkNotes";
    ArrayList<String> correctLetters = new ArrayList<>();
    ArrayList<String> incorrectLetters = new ArrayList<>();
    Temp temp = new Temp(wordTheyGuess);

    @PutMapping("/guess/{letter}")
    public String guessLetter(@PathVariable String letter) {
        if (letter == null || letter.length() != 1){
            return getIncorrectLetters() + "\nErr: Please enter one and only one letter.";
        }
        if (incorrectLetters.contains(letter.toLowerCase()) || correctLetters.contains(letter.toLowerCase())){
            return getIncorrectLetters() + "\nErr: You've already guessed that letter.";
        }

        if (wordTheyGuess.toLowerCase().contains(letter.toLowerCase())) {
            correctLetters.add(letter.toLowerCase());
            temp.updateTemp(letter.toLowerCase(), wordTheyGuess);
        }
        else {
            incorrectLetters.add(letter.toLowerCase());
        }
        return getIncorrectLetters();
    }

    @GetMapping("/word")
    public String getWord() {
        return temp.getTemp().toString();
    }

    private String getIncorrectLetters(){
        StringBuilder printedLetters = new StringBuilder();
        for (String s : incorrectLetters){
            printedLetters.append(s).append(" ");
        }
        printedLetters.append("\n").append(getDiagram());
        return printedLetters.append(temp.getTemp().toString()).toString();
    }

    private String getDiagram(){
        String diagram = "";
        switch (incorrectLetters.size()){
            case 0:
                diagram +=
                        "_______\n" +
                        " |    |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "______|__\n";
                break;
            case 1:
                diagram +=
                        "_______\n" +
                                " |    |\n" +
                                " O    |\n" +
                                "      |\n" +
                                "      |\n" +
                                "______|__\n";
                break;
            case 2:
                diagram +=
                        "_______\n" +
                                " |    |\n" +
                                " O    |\n" +
                                " |    |\n" +
                                "      |\n" +
                                "______|__\n";
                break;
            case 3:
                diagram +=
                        "_______\n" +
                                " |    |\n" +
                                " O    |\n" +
                                " |\\   |\n" +
                                "      |\n" +
                                "______|__\n";
                break;
            case 4:
                diagram +=
                        "_______\n" +
                                " |    |\n" +
                                " O    |\n" +
                                "/|\\   |\n" +
                                "      |\n" +
                                "______|__\n";
                break;
            case 5:
                diagram +=
                        "_______\n" +
                                " |    |\n" +
                                " O    |\n" +
                                "/|\\   |\n" +
                                "  \\   |\n" +
                                "______|__\n";
                break;
            case 6:
                diagram +=
                        "_______\n" +
                                " |    |\n" +
                                " O    |\n" +
                                "/|\\   |\n" +
                                "/ \\   |\n" +
                                "______|__\n";
                break;
            default:
                diagram += "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
                        "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n" +
                        "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
                        "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n" +
                        "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
                        "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                        "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
                        "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                        "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n";
                break;
        }
        return diagram;
    }

}
