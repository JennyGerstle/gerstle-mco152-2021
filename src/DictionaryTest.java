import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest
{
    /**
     * Tests findWords
     */
    @Test
    public void findWord()
    {
        //checks an existing word
        Dictionary dict = new Dictionary("word");

        Boolean tru = dict.findWord();

        Assert.assertEquals(true, tru);

        //checks non-existing word
        Dictionary nonDict = new Dictionary("wr2");

        Boolean fls = nonDict.findWord();

        Assert.assertEquals(false, fls);

    }
}
