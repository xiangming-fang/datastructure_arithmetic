package indi.xm.jy.trie;

import java.util.TreeMap;

public class Trie {

    private class Node{
        // 经过这个节点的前缀个数
        int p;
        // 以这个节点结束的单词个数
        int e;
        TreeMap<Character,Node> next;

        public Node(){
            p = 0;
            e = 0;
            next = new TreeMap<>();
        }
    }

    private int size;

    private Node root;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void insert(String str){
        if (str == null){
            return;
        }
        Node cur = root;
        cur.p ++;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
            cur.p ++;
        }
        cur.e ++;
        size ++;
    }

    public void delete(String str){
        // trie 包含 str 才可以删除
        if (search(str) > 0){
            Node cur = root;
            cur.p --;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
//                if (--cur.next.get(c).p == 0){
                if ( cur.next.get(c).p == 1){
                    cur.next.remove(c);
                    return;
                }
                cur.next.get(c).p --;
                cur = cur.next.get(c);
            }
            cur.e --;
        }
    }

    // 包含 str 字符串的单词
    public int search(String str){
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        return cur.e;
    }

    // 包含这个 str 前缀的有几个字符串
    public int prefixNumber(String str){
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return cur.p;
    }
}
