package gerstle.scrabble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DictionaryApplication extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Dictionary dictionary = new Dictionary();
        LetterBag letterBag = new LetterBag();
        ScrabbleController controller = new ScrabbleController(letterBag, dictionary);

        FXMLLoader  loader = new FXMLLoader(getClass().getResource("/Scrabble_application.fxml"));
        loader.setController(controller);

        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
