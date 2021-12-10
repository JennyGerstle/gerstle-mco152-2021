package gerstle.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;


public class DictionaryController
{
    @FXML
    TextField wordToSearchField;
    @FXML
    TextField ifFoundWordField;

    public void wordSearch(ActionEvent actionEvent) throws IOException
    {
        String word = wordToSearchField.getText();

        String found;
        Dictionary search = new Dictionary();
        if(search.findWord(word))
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
