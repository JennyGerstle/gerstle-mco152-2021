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
        //checks an existing word
        Dictionary dict = new Dictionary("word");
        String[] dictArray = dict.words();
        boolean tru = dict.findWord(dictArray);

        Assert.assertTrue(tru);
    }
    /**
     * Tests findWords when there is not a real word passed
     */
    @Test
    public void findNoWord() throws FileNotFoundException
    {
        //checks non-existing word
        Dictionary nonDict = new Dictionary("wr2");
        String[] dictArray = nonDict.words();

        boolean fls = nonDict.findWord(dictArray);

        Assert.assertFalse(fls);
    }
    /**
     * Tests findWords when there is a mixed case word passed
     */
    @Test
    public void findConfusedWord() throws FileNotFoundException
    {
        //checks non-existing word
        Dictionary conDict = new Dictionary("WoRd");
        String[] dictArray = conDict.words();

        boolean found = conDict.findWord(dictArray);

        Assert.assertTrue(found);
    }
}
