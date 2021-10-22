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
//            if (!avl.isBalance() || !avl.isBST()){
//                throw new RuntimeException("添加操作 发生 不平衡或者不是BST");
//            }
        }
        System.out.println(avl.isBST());
        System.out.println(avl.isBalance());
        System.out.println(avl.getSize());

        for (String word : words) {
            avl.remove(word);
            if (!avl.isBalance() || !avl.isBST()){
                throw new RuntimeException("删除操作 发生 不平衡或者不是BST  " + avl.isBalance() + "  " + avl.isBST());
            }
        }
        System.out.println(avl.getSize());

    }
}
