package com.xm.jy.avl;

import com.xm.jy.array.my.Array;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.avl.my
 * @ClassName: AVLTree
 * @Author: albert.fang
 * @Description: avl bst 进阶成 avl-bst 自平衡二叉搜索树
 * @Date: 2021/8/2 15:28
 */
public class AVLTree<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left;
        public Node right;
        public int height;

        Node(E e, Node left, Node right){
            this.e = e;
            this.left = left;
            this.right = right;
            this.height = 1;
        }
    }

    private Node root;

    private int size;

    // 实现增删改查
    // AVLTree 这里没有改，原因：1、avl没有索引。2、avl的大小情况分别是左树小于父节点，父节点小于右树，简单理解就是avl是个有序的树。
    // 但是我们实现每一个数据结构都会尽量去实现这个数据结构的增删改查四个基础功能

    // 往avl中添加一个元素
    public void add(E e){
        root = add(root,e);
    }

    // 从avl中移除指定元素
    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node,E e){

        // 1、终止条件
        if (node == null){
            return null;
        }

        // 2、更小问题
        if (e.compareTo(node.e) == 0){
            if (node.left == null && node.right == null){
                size --;
                return null;
            }
            if (node.right == null){
                Node maxNode = getMaxNode(node.left);
                maxNode.left = removeMaxNode(node.left);
                size --;
                return maxNode;
            }
            // 该节点没有左节点或者两个节点都有
            Node minNode = getMinNode(node.right);
            minNode.right = removeMinNode(node.right);
            size --;
            return minNode;
        }
        else if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }
        else {
            node.right = remove(node.right,e);
            return node;
        }
    }

    // 修改avl中最大的元素节点值
    public void setMax(E e){
        if (!isEmpty()){
            Node maxNode = getMaxNode(root);
            if (e.compareTo(maxNode.e) > 0){
                maxNode.e = e;
            }
        }
    }

    // 修改avl中最小的元素节点值
    public void setMin(E e){
        if (!isEmpty()){
            Node minNode = getMinNode(root);
            if (e.compareTo(minNode.e) < 0){
                minNode.e = e;
            }
        }
    }

    // 获取avl中最大的节点值
    public E getMax(){
        if (isEmpty()){
            return null;
        }
        return getMaxNode(root).e;
    }

    // 获取avl中最小的节点值
    public E getMin(){
        if (isEmpty()){
            return null;
        }
        return getMinNode(root).e;
    }

    // 中序遍历
    public void inorder(){
        StringBuilder result = new StringBuilder();
        result.append("【 ");
        inorder(root,result);
        result.append("】");
        System.out.println(result.toString());
    }


    // 中序遍历
    // 隐含终止条件：node.left = null 或者 node.right = null;
    private void inorder(Node node,StringBuilder result){
        if (node == null){
            return;
        }
        inorder(node.left,result);
        result.append(node.e).append(" ");
        inorder(node.right,result);
    }

    // 中序遍历
    public void inorder(Array<E> list){
        inorder(root,list);
    }

    // 中序遍历
    private void inorder(Node node,Array<E> list){
        if (node == null){
            return;
        }
        inorder(node.left,list);
        list.addLast(node.e);
        inorder(node.right,list);
    }

    // 中序遍历 先右节点，再左节点
    public void inorderT(Array<E> list){
        inorderT(root,list);
    }

    // 中序遍历 先右节点，再左节点
    private void inorderT(Node node,Array<E> list){
        if (node == null){
            return;
        }
        inorderT(node.right,list);
        list.addLast(node.e);
        inorderT(node.left,list);
    }

    // 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 辅助方法

    /**
     *
     * 在哪个节点上新增节点
     * @param node 需要新增节点的节点
     * @param e 待新增的节点值
     * @return void
     * @author albert.fang
     * @date
     */
    public Node add(Node node,E e){
        // 1、递归终止条件
        // 左树或右树刚好是null
        if (node == null){
            size ++;
            return new Node(e,null,null);
        }
        // 2、比较node节点的值和e的大小关系
        if (e.compareTo(node.e) > 0){
            // 更小问题
            node.right = add(node.right,e);
        }
        else if (e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }
        // 重新计算高度值
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        // 平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced : " + balanceFactor);
        }
        // 相等的元素直接忽略
        return node;
    }

    /**
     *
     * 在node节点上获取最小值的那个节点
     * 因为avl的天然顺序性，所以就注定了，最小的节点值在左树,并且那个节点是最底层没有左子树的那个节点
     * @return com.xm.jy.avl.my.AVLTree<E>.Node
     * @author albert.fang
     * @date
     */
    private Node getMinNode(Node node){
        // 1、终止条件
        if (node.left == null){
            return node;
        }
        // 2、更小问题
        return getMinNode(node.left);
    }

    /**
     *
     * 在node节点上获取最大值的那个节点
     * 因为avl的天然顺序性，所以就注定了，最大的节点值在右树,并且那个节点是最底层没有右子树的那个节点
     * @return com.xm.jy.avl.my.AVLTree<E>.Node
     * @author albert.fang
     * @date
     */
    private Node getMaxNode(Node node){
        // 1、终止条件
        if (node.right == null){
            return node;
        }
        // 2、更小问题
        return getMaxNode(node.right);
    }

    // 移除一个节点中最大的节点
    // 返回移除之后的节点
    private Node removeMaxNode(Node node){
        // 1、终止条件
        if (node.right == null && node.left == null){
            return null;
        }
        else if (node.right == null){
            Node maxNode = getMaxNode(node.left);
            maxNode.left = removeMaxNode(node.left);
            return maxNode;
        }

        // 2、更小问题
        node.right = removeMaxNode(node.right);
        return node;
    }

    // 移除一个节点中最小的节点
    // 返回移除之后的节点
    private Node removeMinNode(Node node){
        // 1、终止条件
        if (node.left == null && node.right == null){
            return null;
        }
        else if (node.left == null){
            Node minNode = getMinNode(node.right);
            minNode.right = removeMinNode(node.right);
            return minNode;
        }
        // 2、更小问题
        node.left = removeMinNode(node.left);
        return node;
    }

    // 执行删除、修改、查询之前先得判断下avl是否为null
    private boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node,E e){
        // 1、终止条件
        if (node == null){
            return false;
        }

        // 2、更小问题
        if (e.compareTo(node.e) == 0){
            return true;
        }

        else if (e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }

        return contains(node.right,e);

    }

    // 获取节点的高度值
    private int getHeight(Node node){
        if (node == null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 判断是否是一棵bst
    public boolean isBST(){
        Array<E> list = new Array<>();
        inorder(root,list);
        for (int i = 1; i < list.getSize(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    // 判断是否是一棵平衡二叉树，任意节点的左右子树高度差不大于1
    public boolean isBalance(){
        return isBalance(root);
    }

    private boolean isBalance(Node node){
        if (node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);
    }


}
