import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * accesses a dictionary file
 */
public class Dictionary
{
    private final String word;
    private final File dictionary = new File("src/dictionary.txt");
    public Dictionary(String word)
    {
        this.word = word;
    }

    /**
     *
     * @ Boolean whether the word is in the dictionary file
     */
    public boolean findWord()
    {
        boolean found = false;
        try
        {
            Scanner wordReader = new Scanner(new FileReader(dictionary));
            while(wordReader.hasNextLine())
            {
                String wordRef = wordReader.next();
                if(word.equalsIgnoreCase(wordRef))
                {
                    found = true;
                    break;
                }
                else
                {
                    wordReader.nextLine();
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return found;
    }
}
