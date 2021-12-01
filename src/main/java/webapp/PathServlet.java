package webapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gerstle.scrabble.Dictionary;
import gerstle.scrabble.DictionaryApplication;
import gerstle.scrabble.DictionaryController;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PathServlet extends HttpServlet
{
    private final Gson gson;
    private final Map<String, String> wordsToDefine;
    private final Dictionary dictionary;
    private final DictionaryController dictionaryController;
    private final DictionaryApplication dictionaryApplication;
    public PathServlet() throws IOException
    {
        wordsToDefine = new HashMap<>();
        dictionary = new Dictionary();
        dictionaryController = new DictionaryController();
        dictionaryApplication = new DictionaryApplication();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException
    {
        PrintWriter out = response.getWriter();

        String word = request.getParameter("word");
        String answer;
        if (dictionary.findWord(word))
        {
            answer = dictionary.getDefinition(word);
        } else
        {
            answer = "word not found";
        }
        String json = gson.toJson(answer);

        out.println(json);
    }
}

