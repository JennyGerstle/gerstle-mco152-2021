package gerstle.scrabble;

import org.junit.Assert;
import java.io.IOException;
import org.junit.Test;

public class DictionaryTest
{
    /**
     * Tests findWords when there is a real word passed
     */
    @Test
    public void findExistsWord() throws IOException
    {
        Dictionary dict = new Dictionary();

        String word = "word";

        boolean tru = dict.findWord(word);

        Assert.assertTrue(tru);
    }
    /**
     * Tests findWords when there is not a real word passed
     */
    @Test
    public void findNoWord() throws IOException
    {
        Dictionary nonDict = new Dictionary();

        String word ="wr2";;

        boolean fls = nonDict.findWord(word);

        Assert.assertFalse(fls);
    }
    /**
     * Tests findWords when there is a mixed case word passed
     */
    @Test
    public void findConfusedWord() throws IOException
    {
        Dictionary conDict = new Dictionary();

        String word = "WoRd";

        boolean found = conDict.findWord(word);

        Assert.assertTrue(found);
    }


    @Test
    public void getDefinition() throws IOException
    {
        Dictionary getDict = new Dictionary();

        String word = "WoRd";

        String def = getDict.getDefinition(word);

        Assert.assertEquals(def, "to express in words (speech sounds that communicate meaning) [v -ED, -ING, -S]");
    }

    @Test
    public void getNoDefinition() throws IOException
    {
        Dictionary noDict = new Dictionary();

        String word = "WRd";

         String def = noDict.getDefinition(word);

        Assert.assertEquals(def, "");
    }
}
