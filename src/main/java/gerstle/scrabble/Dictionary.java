package gerstle.scrabble;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * accesses a dictionary file
 */
public class Dictionary
{
    /**
     *
     * @return list of words
     * @throws FileNotFoundException for when the file is not found
     */
    private Map<String, String> wordsToDefinitions = new HashMap<>();

    public Dictionary() throws FileNotFoundException
    {
        Scanner wordReader = new Scanner(new FileReader("src/main/resources/dictionary.txt"));
        while(wordReader.hasNextLine())
        {
            wordsToDefinitions.put(wordReader.next(), //key
                    wordReader.nextLine().trim() //value
            );
        }
    }
    /**
     * @ Boolean whether the word is in the dictionary file
     */
    public boolean findWord(String word)
    {
            return wordsToDefinitions.containsKey((word.toUpperCase()));
    }

    public String getDefinition(String word)
    {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size()
    {
        return wordsToDefinitions.size();
    }
}
