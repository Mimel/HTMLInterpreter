package parsing;

import parsing.html.HtmlParser;

import java.util.HashMap;

/**
 * Factory object used to create parsers based on a given file extension.
 * All parsers act as prototypes inside a HashMap, that are deep-copied
 * when requested.
 */
final class ParserFactory {

    /**
     * A HashMap relating file extensions to the parser that is
     * suitable to parse the text.
     */
    private static HashMap<String, Parser> parserGenerator;

    /**
     * Initializes all parsers to the HashMap.
     * NOTE that on creation of a new Parser inheritor,
     * this function must be updated in order for the
     * inheritor to be used.
     */
    private static void initializeParsers() {
        if(parserGenerator == null) {
            parserGenerator = new HashMap<>();
            parserGenerator.put("html", new HtmlParser());
            //Implies searching for index.html.
            parserGenerator.put("/", new HtmlParser());
        }
    }

    /**
     * Returns a parser suiting the file extension given.
     * If the parser set has not been instantiated, then this method
     * instantiates it before searching.
     * @param query A file extension.
     * @return The accompanying parser, or null if none exists.
     */
    static Parser getParser(String query) {
        if(parserGenerator == null) {
            initializeParsers();
        }

        return parserGenerator.get(query.toLowerCase()).deepCopy();
    }
}
