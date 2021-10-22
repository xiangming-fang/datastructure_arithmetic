package indi.xm.jy.set;

import indi.xm.jy.avl.AVLTree;
import indi.xm.jy.bst.BST;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.set
 * @ClassName: AVLTreeSet
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/10/22 16:56
 */
public class AVLTreeSet<E extends Comparable<E>> implements Set<E>  {

    private AVLTree<E> avlTree;

    public AVLTreeSet(){
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }
}
