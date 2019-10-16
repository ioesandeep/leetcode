package hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {
    class Node {
        Map<String, Node> children;
        String name;
        String content;

        Node() {
            children = new TreeMap<>();
        }
    }

    Node root;

    public FileSystem() {
        root = new Node();
        root.name = "/";
    }

    void insert(String path, String content) {
        String[] paths = path.split("/");
        Node curr = root;
        for (int i = 1; i < paths.length; i++) {
            String name = paths[i];
            if (!curr.children.containsKey(name)) {
                curr.children.put(name, new Node());
            }
            curr = curr.children.get(name);
            curr.name = name;
        }
        if (content != "") {
            curr.content = curr.content == null ? content : curr.content + content;
        }
    }

    Node search(String path) {
        String[] paths = path.split("/");
        Node curr = root;
        for (int i = 1; i < paths.length; i++) {
            String name = paths[i];
            curr = curr.children.get(name);
        }

        return curr;
    }

    public List<String> ls(String path) {
        List<String> res = new LinkedList<>();
        Node node = search(path);
        if (node.content == null) {
            res.addAll(node.children.keySet());
            return res;
        }
        res.add(node.name);
        return res;
    }

    public void mkdir(String path) {
        insert(path, "");
    }

    public void addContentToFile(String filePath, String content) {
        insert(filePath, content);
    }

    public String readContentFromFile(String filePath) {
        Node node = search(filePath);
        return node == null ? null : node.content;
    }
}
