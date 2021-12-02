package indi.xm.jy.trie;

import java.util.TreeMap;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.trie
 * @ClassName: SensitiveTrie
 * @Author: albert.fang
 * @Description: 敏感词字典树
 * @Date: 2021/11/29 17:19
 */
public class SensitiveTrie {

    private class Node{
        private TreeMap<Character,Node> next;
        private boolean isWord;
        public Node(TreeMap<Character,Node> next,boolean isWord){
            this.next = next;
            this.isWord = isWord;
        }
        public Node(){
            this(new TreeMap<Character,Node>(),false);
        }
    }

    private Node root;

    private int size;

    public SensitiveTrie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void addWord(String word){
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (temp.next.get(cur) == null){
                temp.next.put(cur,new Node());
            }
            temp = temp.next.get(cur);
        }
        // 如果之前没加过，那么添加进去 && size + 1
        if (!temp.isWord){
            temp.isWord = true;
            size ++;
        }
    }

    public boolean contains(String word){
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (temp.next.get(cur) == null){
                return false;
            }
            temp = temp.next.get(cur);
        }
        // 注意这里，包含word路径，并不代表包含word单词
        return temp.isWord;
    }

    public boolean containsPrefix(String prefix){
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (temp.next.get(cur) == null){
                return false;
            }
            temp = temp.next.get(cur);
        }
        // 到这里说明包含这个路径，直接返回true即可
        return true;
    }

    // 判断 word 中是否包含敏感词
    public boolean containsSensitiveWord(String word) {
        Node temp = root;
        return false;
    }

}
