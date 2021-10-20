package indi.xm.jy.trie;

import java.util.TreeMap;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.trie
 * @ClassName: Trie
 * @Author: albert.fang
 * @Description: 字典树、前缀树：专门为字符串设计的数据结构
 * @Date: 2021/10/19 19:19
 */
public class Trie {

    private class Node{

        /**
         * 标明该节点是否完成一个单词
         */
        public boolean isWord;

        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }

    }

    private Node root;

    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获取Trie中存储的单词量
    public int getSize(){
        return size;
    }

    // 向trie中添加一个新的单词word
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            // 添加进来的word最后一个字符
            cur.isWord = true;
            size ++;
        }
    }

    // 查询单词word是否在trie中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null ){
                return false;
            }
            cur = cur.next.get(c);
        }
        // 如果isword为false，那么也表示不存在
        return cur.isWord;
    }

    // 查询是否在trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        // 判断前缀，不必再判断isWord是否表示一个单词的结束
        return true;
    }

}
