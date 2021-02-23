package gerstle.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;


public class DictionaryController
{
    @FXML
    TextField wordToSearchField;
    @FXML
    TextField ifFoundWordField;

    public void wordSearch(ActionEvent actionEvent) throws FileNotFoundException
    {
        String word = wordToSearchField.getText();

        String found;
        Dictionary search = new Dictionary(word);
        String[] dictArray = search.words();
        if(search.findWord(dictArray))
        {
            found = "exists";
        }
        else
        {
            found = "does not exist";
        }
        ifFoundWordField.setText(found);
    }
}
