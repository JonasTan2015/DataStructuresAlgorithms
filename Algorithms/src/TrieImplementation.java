import java.util.HashMap;

/**
 * Created by 310288079 on 7/6/2017.
 */



class Node {
    HashMap<Character, Node> children = null;
    boolean isWord = false;
    String word = null;

    public Node(){
        this.children = new HashMap<Character, Node>();
    }
}

class Trie{
    Node root = null;
    public Trie(){
        this.root = new Node();
    }

    public void insert(String str){
        Node curr = root;
        char ch = '0';
        for(int i = 0; i < str.length(); i ++){
            ch = str.charAt(i);
            if(curr.children.containsKey(ch) == false){
                curr.children.put(ch, new Node());
            }
            curr = curr.children.get(ch);
            if(i == str.length() - 1){
                curr.isWord = true;
                curr.word = str;
            }
        }
    }

    public boolean hasPrefix(String prefix){
        Node curr = root;
        char ch = '0';
        for(int i = 0; i < prefix.length(); i ++){
            ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }
        return true;
    }

    public boolean hasWord(String word){
        Node curr = root;
        char ch = '0';
        for(int i = 0; i < word.length(); i ++){
            ch = word.charAt(i);
            if(!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);

            if(i == word.length() - 1){
                return curr.isWord;
            }
        }
        return true;
    }
}

public class TrieImplementation {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("dictionary");
        trie.insert("dimension");
        System.out.println(trie.hasWord("dictionary"));
        System.out.println(trie.hasWord("dictate"));
    }

}