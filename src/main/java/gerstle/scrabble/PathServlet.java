package gerstle.scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PathServlet extends HttpServlet
{
    private final Dictionary dictionary;
    public PathServlet() throws IOException
    {
        dictionary = new Dictionary();
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
        String json = answer;

        out.println(json);
    }
}

