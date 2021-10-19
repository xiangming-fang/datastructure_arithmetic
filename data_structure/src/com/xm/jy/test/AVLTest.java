package com.xm.jy.test;

import com.xm.jy.avl.AVLTree;
import com.xm.jy.utils.FileOperatorUtils;
import org.junit.Test;

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
        LinkedList<String> words = FileOperatorUtils.getWords("pride-and-prejudice.txt");
        AVLTree<String> avl = new AVLTree<>();
        for (String word : words) {
            avl.add(word);
        }
        System.out.println(avl.isBST());
        System.out.println(avl.isBalance());

    }
}
