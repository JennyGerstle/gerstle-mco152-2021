package gerstle.scrabble;

import java.io.*;
import java.util.*;

/**
 * accesses a dictionary file
 */
public class Dictionary
{
    /**
     *
     * @return list of words
     * @throws IOException for when the file is not found
     */
    private final Map<String, String> wordsToDef = new HashMap<>();

    public Dictionary() throws IOException
    {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = null;
        if (in != null)
        {
            reader = new BufferedReader(new InputStreamReader(in));
        }
        String dictionaryLine;
        while ((dictionaryLine = reader.readLine()) != null)
        {
            int index = dictionaryLine.indexOf(" ");
            String[] pairs = dictionaryLine.split(" ", 2);
            wordsToDef.put(
                    index == -1 ? dictionaryLine : dictionaryLine.substring(0, index), //key
                    index > -1 ? dictionaryLine.substring(index + 1) : null);
        }
    }
    /**
     * @ Boolean whether the word is in the dictionary file
     */
    public boolean findWord(String word)
    {
            return wordsToDef.containsKey((word.toUpperCase()));
    }

    public String getDefinition(String word)
    {
        String definition = wordsToDef.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size()
    {
        return wordsToDef.size();
    }
}
