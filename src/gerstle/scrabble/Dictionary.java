package gerstle.scrabble;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * accesses a dictionary file
 */
public class Dictionary
{
    private final String word;
    public Dictionary(String word)
    {
        this.word = word;
    }

    /**
     *
     * @return list of words
     * @throws FileNotFoundException for when the file is not found
     */
    public String[] words() throws FileNotFoundException
    {
        ArrayList<String> words = new ArrayList<>();
        Scanner wordReader = new Scanner(new FileReader("src/gerstle/scrabble/dictionary.txt"));
        while(wordReader.hasNextLine())
        {
            String wordRef = wordReader.next();
            words.add(wordRef.toUpperCase());
            wordReader.nextLine();
        }
        Collections.sort(words);
        return words.toArray(new String[0]);
    }
    /**
     * @ Boolean whether the word is in the dictionary file
     */
    public boolean findWord(String[] diArray)
    {
            return Arrays.binarySearch(diArray, word.toUpperCase()) >=0;
    }
}
