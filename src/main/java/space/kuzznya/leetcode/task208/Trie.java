package space.kuzznya.leetcode.task208;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    boolean isEnd;
    final Map<Character, TrieNode> children;

    public TrieNode(boolean isEnd) {
        this.isEnd = isEnd;
        this.children = new HashMap<>();
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(false);
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            cur = cur.children.computeIfAbsent(word.charAt(i), c -> new TrieNode(false));
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            cur = cur.children.get(word.charAt(i));
            if (cur == null) {
                return false;
            }
        }
        return cur != null && cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            cur = cur.children.get(prefix.charAt(i));
            if (cur == null) {
                return false;
            }
        }
        return cur != null;
    }
}
