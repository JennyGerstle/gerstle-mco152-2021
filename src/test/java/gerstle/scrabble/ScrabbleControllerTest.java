package gerstle.scrabble;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ScrabbleControllerTest
{
    private LetterBag letterBag;
    private Dictionary dictionary;
    private ScrabbleController controller;
    private List<Label> answerLabels;
    private List<Label> letterLabels;
    private Label scoreLabel;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public  void  initialize()
    {
        // given
        givenScrabbleController();
        doReturn("T",
                "G",
                "L")
                .when(letterBag).nextLetter();

        // when
        controller.initialize();

        // then
        verify(controller.letterLabels.get(0)).setText("T");
        verify(controller.letterLabels.get(1)).setText("G");
        verify(controller.letterLabels.get(2)).setText("L");
        verify(letterBag, times(3)).nextLetter();
        doReturn("T", "G", "L", "I", "E").when(letterBag).nextLetter();

        controller.initialize();

        verify(controller.letterLabels).get(0).setText("T");
        verify(controller.letterLabels).get(1).setText("G");
        verify(controller.letterLabels).get(2).setText("L");
        verify(letterBag, times(3)).nextLetter();
    }

    @Test
    public void onClear_noAnswer() {
        // given
        givenScrabbleController();

        // when
        controller.onClear(mock(ActionEvent.class));

        // then
        for (Label label : answerLabels) {
            verify(label).getText();
        }

        for (Label label : letterLabels) {
            //verifyNoInteractions(label);
            //verify(label, never()).setText(anyString());
        }
    }


    @Test
    public void onClear_fullAnswer() {
        // given
        givenScrabbleController();
        doReturn("G").when(answerLabels.get(0)).getText();
        doReturn("H").when(answerLabels.get(1)).getText();
        doReturn("E").when(answerLabels.get(2)).getText();
        doReturn("").when(letterLabels.get(0)).getText();
        doReturn("").when(letterLabels.get(1)).getText();
        doReturn("").when(letterLabels.get(2)).getText();

        // when
        controller.onClear(mock(ActionEvent.class));

        // then
        verify(answerLabels.get(0)).getText();
        verify(answerLabels.get(0)).setText("");
        verify(answerLabels.get(1)).getText();
        verify(answerLabels.get(1)).setText("");
        verify(answerLabels.get(2)).getText();
        verify(answerLabels.get(2)).setText("");
        verify(letterLabels.get(0)).setText("G");
        verify(letterLabels.get(1)).setText("H");
        verify(letterLabels.get(2)).setText("E");
    }

    @Test
    public void onClear_someAnswer() {
        // given
        givenScrabbleController();
        doReturn("").when(answerLabels.get(0)).getText();
        doReturn("H").when(answerLabels.get(1)).getText();
        doReturn("").when(answerLabels.get(2)).getText();

        doReturn("G").when(letterLabels.get(0)).getText();
        doReturn("").when(letterLabels.get(1)).getText();
        doReturn("").when(letterLabels.get(2)).getText();

        // when
        controller.onClear(mock(ActionEvent.class));

        // then
        verify(answerLabels.get(1)).getText();
        verify(answerLabels.get(1)).setText("");
        verify(letterLabels.get(1)).setText("H");
        verify(letterLabels.get(0), never()).setText(anyString());
        verify(letterLabels.get(2), never()).setText(anyString());
    }

    @Test
    public void onAnswerClicked() {
        // given
        givenScrabbleController();
        doReturn("").when(answerLabels.get(0)).getText();
        doReturn("H").when(answerLabels.get(1)).getText();
        doReturn("").when(answerLabels.get(2)).getText();

        doReturn("G").when(letterLabels.get(0)).getText();
        doReturn("").when(letterLabels.get(1)).getText();
        doReturn("").when(letterLabels.get(2)).getText();
        MouseEvent event = mock(MouseEvent.class);
        doReturn(answerLabels.get(1)).when(event).getSource();

        // when
        controller.onAnswerClicked(event);

        // then
        verify(answerLabels.get(1)).setText("");
        verify(letterLabels.get(1)).setText("H");
        verify(letterLabels.get(0), never()).setText(anyString());
        verify(letterLabels.get(2), never()).setText(anyString());
    }

    @Test
    public void onLetterClicked() {
        // given
        givenScrabbleController();
        doReturn("G").when(answerLabels.get(0)).getText();
        doReturn("").when(answerLabels.get(1)).getText();
        doReturn("").when(answerLabels.get(2)).getText();

        doReturn("").when(letterLabels.get(0)).getText();
        doReturn("H").when(letterLabels.get(1)).getText();
        doReturn("").when(letterLabels.get(2)).getText();
        MouseEvent event = mock(MouseEvent.class);
        doReturn(letterLabels.get(1)).when(event).getSource();

        // when
        controller.onLetterClicked(event);

        // then
        verify(letterLabels.get(1)).setText("");
        verify(answerLabels.get(1)).setText("H");
        verify(answerLabels.get(0), never()).setText(anyString());
        verify(answerLabels.get(2), never()).setText(anyString());
    }

    @Test
    public void onSubmit_validWord() {
        // given
        givenScrabbleController();
        doReturn("C").when(answerLabels.get(0)).getText();
        doReturn("A").when(answerLabels.get(1)).getText();
        doReturn("T").when(answerLabels.get(2)).getText();
        doReturn("").when(letterLabels.get(0)).getText();
        doReturn("").when(letterLabels.get(1)).getText();
        doReturn("").when(letterLabels.get(2)).getText();
        doReturn(true).when(dictionary).findWord("CAT");
        doReturn("E", "S", "T")
                .when(letterBag).nextLetter();

        // when
        controller.onSubmit(mock(ActionEvent.class));

        // then
        verify(dictionary).findWord("CAT");
        verify(scoreLabel).setText("3");
        Assert.assertEquals(3, controller.scoreLabel);
        // TODO verify new letters
        // TODO verify clear labels
    }

    @Test
    public void onSubmit_invalidWord() {
        // given
        givenScrabbleController();
        doReturn("Q").when(answerLabels.get(0)).getText();
        doReturn("W").when(answerLabels.get(1)).getText();
        doReturn("S").when(answerLabels.get(2)).getText();
        doReturn(false).when(dictionary).findWord("QWS");

        // when
        controller.onSubmit(mock(ActionEvent.class));

        // then
        verify(dictionary).findWord("QWS");
        //verifyNoInteractions(pointsLabel);
        Assert.assertEquals(0, controller.scoreLabel);
        // TODO verify no new letters
        // TODO verify labels not cleared
    }

    private void givenScrabbleController() {
        letterBag = mock(LetterBag.class);
        dictionary = mock(Dictionary.class);
        controller = new ScrabbleController(letterBag, dictionary);
        letterLabels = Arrays.asList(
                mock(Label.class),
                mock(Label.class),
                mock(Label.class)
        );
        controller.letterLabels = letterLabels;
        answerLabels = Arrays.asList(
                mock(Label.class),
                mock(Label.class),
                mock(Label.class)
        );
        controller.answerLabels = answerLabels;
        scoreLabel = mock(Label.class);
        controller.scoreLabel = scoreLabel;
    }

}
