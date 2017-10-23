package parsing.html;

import java.util.ArrayList;

/**
 * An HTML element that can fit into a DOM tree.
 */
public class DomTreeNode {

    /**
     * The tag name of the element.
     */
    private String tag;

    /**
     * The parent of the node. If this is null, then this node is the
     * head of the entire DOM tree.
     */
    DomTreeNode parent;

    /**
     * The children of the node.
     */
    ArrayList<DomTreeNode> children;

    DomTreeNode(String tagName) {
        this.tag = tagName;
    }

    public String getTag() {
        return tag;
    }
}
