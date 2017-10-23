package parsing;

import parsing.html.DomTreeNode;

/**
 * A parser denotes an algorithm that translates plain text into data
 * that meshes with the browser environment in a way that is accordant to
 * the language and the code therein.
 */
public interface Parser {

    /**
     * Parses a given chunk of text, and adjusts the browser environment accordingly.
     */
    void parse();

    /**
     * Takes in a section of language-compliant text to be parsed.
     * @param chunk A section of text.
     */
    void receive(char[] chunk);

    /**
     * Returns the adjusted environment after parsing.
     * @return The browser environment.
     */
    DomTreeNode give();

    /**
     * Returns an exact, deep copy of the object, such that adjusting copy
     * does not adjust the original object, and vice versa.
     * @return A deep copy of this object.
     */
    Parser deepCopy();
}
