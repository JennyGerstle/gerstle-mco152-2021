package gerstle.scrabble;

import jdk.internal.org.jline.utils.InputStreamReader;

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
    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public Dictionary() throws IOException
    {
        InputStream in = getClass().getClassLoader().getResourceAsStream("resources/dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String dictionaryLine;
        while ((dictionaryLine = reader.readLine()) != null)
        {
            int index = dictionaryLine.indexOf(" ");
            String[] pairs = dictionaryLine.split(" ", 2);
            wordsToDefinitions.put(
                    index == -1 ? dictionaryLine : dictionaryLine.substring(0, index), //key
                    index > -1 ? dictionaryLine.substring(index + 1) : null);
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
