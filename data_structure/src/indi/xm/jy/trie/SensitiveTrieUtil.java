package indi.xm.jy.trie;

import java.io.*;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.trie
 * @ClassName: SensitiveTrieUtil
 * @Author: albert.fang
 * @Description: 敏感词字典树工具类
 * @Date: 2021/11/29 17:49
 */
public class SensitiveTrieUtil {

    public static SensitiveTrie trie = new SensitiveTrie();


    public SensitiveTrieUtil(){
        try {
            FileReader reader = new FileReader("banword.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while (bufferedReader.ready()){
                 line = bufferedReader.readLine();
                trie.addWord(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 判断 word 中是否包含敏感词
    public static boolean containsSensitiveWord(String word){
        return trie.containsSensitiveWord(word);
    }
}
