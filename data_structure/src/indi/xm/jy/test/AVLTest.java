package indi.xm.jy.test;

import indi.xm.jy.avl.AVLTree;
import indi.xm.jy.utils.FileOperation;
import indi.xm.jy.utils.FileOperatorUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: AVLTest
 * @Author: albert.fang
 * @Description: avltest
 * @Date: 2021/8/24 14:57
 */
public class AVLTest {

    @Test
    public void testAVLBalancedFactor(){
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words);
        AVLTree<String> avl = new AVLTree<>();
        for (String word : words) {
            avl.add(word);
        }
        System.out.println(avl.isBST());
        System.out.println(avl.isBalance());

    }
}
