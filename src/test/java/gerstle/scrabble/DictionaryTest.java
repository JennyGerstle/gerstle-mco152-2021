package gerstle.scrabble;

import org.junit.Assert;
import java.io.FileNotFoundException;
import org.junit.Test;

public class DictionaryTest
{
    /**
     * Tests findWords when there is a real word passed
     */
    @Test
    public void findExistsWord() throws FileNotFoundException
    {
        Dictionary dict = new Dictionary();
        
        String word = "word";
        String[] dictArray = dict.Dictionary(word);

        boolean tru = dict.findWord(dictArray, word);

        Assert.assertTrue(tru);
    }
    /**
     * Tests findWords when there is not a real word passed
     */
    @Test
    public void findNoWord() throws FileNotFoundException
    {
        Dictionary nonDict = new Dictionary();

        String word ="wr2";
        String[] dictArray = nonDict.Dictionary(word);

        boolean fls = nonDict.findWord(dictArray, word);

        Assert.assertFalse(fls);
    }
    /**
     * Tests findWords when there is a mixed case word passed
     */
    @Test
    public void findConfusedWord() throws FileNotFoundException
    {
        Dictionary conDict = new Dictionary();

        String word = "WoRd";
        String[] dictArray = conDict.Dictionary("WoRd");

        boolean found = conDict.findWord(dictArray, word);

        Assert.assertTrue(found);
    }
}
