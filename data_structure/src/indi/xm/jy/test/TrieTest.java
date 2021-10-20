package indi.xm.jy.test;

import indi.xm.jy.set.BSTSet;
import indi.xm.jy.trie.Trie;
import indi.xm.jy.utils.FileOperatorUtils;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: TrieTest
 * @Author: albert.fang
 * @Description: 字典树测试用例
 * @Date: 2021/10/19 19:32
 */
public class TrieTest {

    @Test
    public void trieAdd(){
        Trie trie = new Trie();
        trie.add("asdf");
        trie.add("asdfe");
        System.out.println(trie.getSize());
    }

    @Test
    public void trieContains(){
        Trie trie = new Trie();
        trie.add("asdf");
        trie.add("asdfe");
        System.out.println(trie.contains("asdf"));
        System.out.println(trie.contains("asdfsdf"));
    }

    @Test
    public void triePrefix(){
        Trie trie = new Trie();
        trie.add("asdf");
        trie.add("asdfe");
        System.out.println(trie.isPrefix("asdf"));
        System.out.println(trie.isPrefix("asd"));
        System.out.println(trie.isPrefix("asdfx"));
    }

    @Test
    public void trieTest(){
        LinkedList<String> words = FileOperatorUtils.getWords("pride-and-prejudice.txt");
        LinkedList<String> words1 = FileOperatorUtils.getWords("pride-and-prejudice.txt");
        LinkedList<String> words2 = FileOperatorUtils.getWords("pride-and-prejudice.txt");
        LinkedList<String> words3 = FileOperatorUtils.getWords("pride-and-prejudice.txt");
        words1.addAll(words);
        words1.addAll(words2);
        words1.addAll(words3);
        long start1 = System.nanoTime();
        BSTSet bstSet = new BSTSet<>();
        for (String word : words1) {
            bstSet.add(word);
        }
        for (String word : words1) {
            bstSet.contains(word);
        }
        long end1 = System.nanoTime();
        System.out.println((end1-start1)/1000000000.0);

        long start = System.nanoTime();
        Trie trie = new Trie();
        for (String word : words1) {
            trie.add(word);
        }
        for (String word : words1) {
            trie.contains(word);
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1000000000.0);
    }
}
