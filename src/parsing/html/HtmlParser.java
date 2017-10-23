package parsing.html;

import parsing.FileLoader;

import java.util.Arrays;

/**
 * A parser capable of interpreting .html files and converting the data therein into a
 * DOM tree.
 */
public class HtmlParser implements parsing.Parser {
    private DomTreeNode DOM;

    private char[] loadedChunk;

    private static final char START_TAG = '<';
    private static final char END_TAG = '>';
    private static final char PROPERTY_DELIMITER = ' ';

    public HtmlParser() {
        this.loadedChunk = new char[FileLoader.CHUNK_SIZE];
    }

    public void parse() {
        System.out.println(loadedChunk);
    }

    public void receive(char[] chunk) {
        loadedChunk = Arrays.copyOf(chunk, chunk.length);
    }

    public DomTreeNode give() {
        return DOM;
    }

    public parsing.Parser deepCopy() {
        return new HtmlParser();
    }
}
