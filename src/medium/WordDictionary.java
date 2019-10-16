package medium;

public class WordDictionary {
    class Node {
        Node[] children;
        boolean isLast;

        Node() {
            children = new Node[26];
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isLast = true;
    }

    boolean search(Node node, char[] chars, int pos) {
        if (node == null) {
            return false;
        }

        if (pos == chars.length) {
            return node.isLast;
        }

        char ch = chars[pos];

        if (ch != '.') {
            return search(node.children[ch - 'a'], chars, pos + 1);
        }

        for (Node c : node.children) {
            if (c == null) {
                continue;
            }
            if (search(c, chars, pos + 1)) {
                return true;
            }
        }

        return false;
    }

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }
}
