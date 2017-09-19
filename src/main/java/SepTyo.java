import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.*;

/**
 * The Class sepTYO.
 */
public class SepTyo {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    /**
     * Finds the number of instances of a given word.
     *
     * @param wordToCount the word to count
     * @param text the test
     */
    public static void wordCount(final String wordToCount, final String text) {
        String[] words = splitText(text);
        //final String wordToCount = "prince";
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(wordToCount)) {
                count++;
            }
        }
        System.out.println(count);

    }
    /**
     * Splits a text into an array of strings removing punctuation and spaces.
     *
     * @param text the text to split
     * @return the text as a string array
     */
    public static String[] splitText(final String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        return words;
    }
    /**
     *Finds the number of unique words in a passage.
     *
     *@param text the text you are searching;
     *@return the number of unique words
     */
    public static int uniqueWords(final String text) {
        String[] words = splitText(text);
        ArrayList<String> uniqueWords = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (!uniqueWords.contains(words[i])) {
                uniqueWords.add(words[i]);
            }
        }
        return uniqueWords.size();
    }
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        //String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String text = "hi there, my name is rag hi ava";
        System.out.println(uniqueWords(text));

    }
}
