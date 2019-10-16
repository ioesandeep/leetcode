package leetcode.medium;

class Trie {
    class Node {
        Node[] children;
        boolean end;

        Node() {
            children = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.end = true;
    }

    protected Node getEndNode(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return null;
            }
            curr = curr.children[idx];
        }
        return curr;
    }

    public boolean search(String word) {
        Node last = getEndNode(word);
        return last != null && last.end;
    }

    public boolean startsWith(String prefix) {
        return getEndNode(prefix) != null;
    }
}