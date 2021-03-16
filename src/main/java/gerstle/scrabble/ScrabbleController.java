package gerstle.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController
{

    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;
    @FXML
    Label scoreNum;

    private LetterBag letterBag = new LetterBag();
    private int count = 0;
    private int points = 0;

    private Dictionary dictionary;

    public ScrabbleController()
    {
        try{
            dictionary = new Dictionary();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        for(Label label : letterLabels) {
            label.setText(letterBag.nextLetter());
        }
    }
    public void onAnswerClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();

    }

    public void onClear(ActionEvent event)
    {
        count = 0;
        for(Label ansLabel: answerLabels)
        {
            if(!ansLabel.getText().equals(" "))
            {
                for(Label letLabel: letterLabels)
                {
                    if (!letLabel.getText().equals(" "))
                    {
                        letLabel.setText(ansLabel.getText());
                    }
                }
                ansLabel.setText(" ");
            }
            else
                {
                break;
            }
        }

    }

    public void onSubmit(ActionEvent event)
    {
        /**if(dictionary.findWord(answerLabels.toString()))
        {
            points = answerLabels.toString().length();
            scoreNum.setText(String.valueOf(points));
        }*/

    }

    public void onLetterClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
        Label ansLabel =(Label) answerLabels.get(count);
        ansLabel.setText(label.getText());
        label.setText(" ");
        count++;

    }
}
