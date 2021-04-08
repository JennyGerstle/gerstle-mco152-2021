package gerstle.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import java.util.List;

public class ScrabbleController
{

    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;
    @FXML
    Label scoreLabel;

    private int score = 0;

    private final LetterBag letterBag;
    private final Dictionary dictionary;

    //Dependency injunction (ie depends on other)
    // so pass those objects in the constructor.
    public ScrabbleController(LetterBag letterBag, Dictionary dictionary)
    {
        this.letterBag = letterBag;
        this.dictionary = dictionary;
    }

    @FXML
    public void initialize()
    {
        for (Label label : letterLabels)
        {
            label.setText(letterBag.nextLetter());
        }
    }

    /**
     * Return the letter in this answerLabel to an empty letterLabel if this Label is not empty.
     *
     * @param event
     */
    public void onAnswerClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
        String letter = label.getText();
        if (!letter.isEmpty())
        {
            label.setText("");
            for (Label letterLabel : letterLabels)
            {
                String s = letterLabel.getText();
                if (s.isEmpty())
                {
                    letterLabel.setText(letter);
                    break;
                }
            }
        }

    }

    /**
     * Returns the letters in answerLabels to letterLabels
     *
     * @param event
     */
    public void onClear(ActionEvent event)
    {
        for (Label answerLabel : answerLabels)
        {
            String letter = answerLabel.getText();
            if (letter != null && !letter.isEmpty())
            {
                answerLabel.setText("");
                for (Label letterLabel : letterLabels)
                {
                    if (letterLabel.getText().isEmpty())
                    {
                        letterLabel.setText(letter);
                        break;
                    }
                }
            }
        }
    }

    public void onSubmit(ActionEvent event)
    {
        StringBuilder build = new StringBuilder();
        for (Label label : answerLabels)
        {
            String letter = label.getText();
            if (letter.isEmpty())
            {
                break;
            }
            build.append(letter);
        }
        String word = build.toString();
        if (dictionary.findWord(word))
        {
            addPoints(word);
            scoreLabel.setText(String.valueOf(score));
            clearAnswerLabels();
            addNewLetters();
        }

    }

    public void addPoints(String word)
    {
        switch (word.length())
        {
            case 2:
                score += 2;
                break;
            case 3:
                score += 3;
                break;
            case 4:
                score += 5;
                break;
            case 5:
                score += 7;
                break;
            case 6:
                score += 11;
                break;
            case 7:
                score += 13;
                break;
        }
    }

    private void addNewLetters()
    {
        for (Label label : letterLabels)
        {
            if (label.getText().isEmpty())
            {
                label.setText(letterBag.nextLetter());
            }
        }
    }

    private void clearAnswerLabels()
    {
        for (Label label : answerLabels)
        {
            label.setText("");
        }
    }

    public void onLetterClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
        String letter = label.getText();
        if (!letter.isEmpty())
        {
            label.setText("");
            for (Label answerLabel : answerLabels)
            {
                String s = answerLabel.getText();
                if (s.isEmpty())
                {
                    answerLabel.setText(letter);
                    break;
                }
            }
        }
    }
}