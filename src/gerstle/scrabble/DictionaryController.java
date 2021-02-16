package gerstle.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class DictionaryController
{
    @FXML
    TextField wordToSearchField;
    @FXML
    TextField ifFoundWordField;

    public void wordSearch(ActionEvent actionEvent)
    {
        String word = wordToSearchField.getText();

        String found;
        Dictionary search = new Dictionary(word);
        if(search.findWord())
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
