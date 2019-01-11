package DataStructure.Trie;

public class Trie {
    class TrieNode {
        // N links to node children
        private TrieNode[] links;

        private final int N = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[N];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    // Time  : O(m) where m is the length of the key
    // Space : O(m)
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    // Time  : O(m) where m is the length of the key
    // Space : O(1)
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that
     * starts with the given prefix. */
    // Time  : O(m) where m is the length of the key
    // Space : O(1)
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();

        obj.insert("apple");
        boolean hasApple = obj.search("apple");
        if (hasApple) {
            System.out.println("apple is in the trie");
        } else {
            System.out.println("apple is NOT in the trie");
        }

        boolean hasApp = obj.search("app");
        if (hasApp) {
            System.out.println("app is in the trie");
        } else {
            System.out.println("app is NOT in the trie");
        }

        boolean startsWithApp = obj.startsWith("app");
        if (startsWithApp) {
            System.out.println("app is a prefix in the trie");
        } else {
            System.out.println("app is NOT a prefix in the trie");
        }
    }
}
