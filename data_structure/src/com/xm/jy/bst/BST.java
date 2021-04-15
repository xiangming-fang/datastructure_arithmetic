package com.xm.jy.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/10/29 13:23
 * @description: 二分搜索树的实现 binary search tree
 */
public class BST<E extends Comparable<E>> {

    // BST 中的节点，内部私有类，外部用户不可见
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 实现BST的CRUD

    // 在BST里添加一个元素
    public void add(E e){
        if (root == null){
            root = new Node(e);
            size ++;
        }else {
            add(root,e);
        }
    }

    private void add(Node node,E e){
        // 1、终止条件
        if (e.compareTo(node.e) == 0){
            return;
        }
        else if (e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }
        else if (e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        // 2、更小的相同问题
        if (e.compareTo(node.e) < 0){
            add(node.left,e);
        }
        else {
            add(node.right,e);
        }
    }

    // 判断BST中是否包含该元素
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if (node == null){
            return false;
        }

        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    // BST 的前中后三种遍历方式

    // 1、BST 的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        // 打印当前根节点的值
        System.out.println(node.e);
        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    // 2、BST 的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 3、BST 的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 借助栈这种数据结构，实现BST的非递归前序遍历
    public void preOrderNR(){
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 借助Queue这种数据结构，实现BST的层次遍历
    public void levelOrder(){
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 找到BST中的最小值和最大值

    // BST中最小值
    public E getMin(){
        if (size == 0)
            throw new IllegalArgumentException("getMin failed,BST中没有节点");
        return getMin(root).e;
    }

    private Node getMin(Node node) {
        if (node.left == null)
            return node;
        return getMin(node.left);
    }

    // 去除一棵BST的最小值节点
    // 返回去除最小值节点之后的一棵BST
    public Node removeMin(){
        return removeMin(root);
    }

    // 待删除节点的右节点，取代该删除节点。
    private Node removeMin(Node node) {
        if (node.left == null){
            Node right = node.right;
            node.right = null;
            size --;
            return right;
        }
        // 这一行好好理解下，进来的一棵树，删除之后，衔接删除节点的右节点
        node.left = removeMin(node.left);
        return node;
    }

    // BST中最大值
    public E getMax(){
        if (size == 0)
            throw new IllegalArgumentException("getMax failed,BST中没有节点");
        return getMax(root).e;
    }

    private Node getMax(Node node) {
        if (node.right == null)
            return node;
        return getMax(node.right);
    }

    // 去除一棵BST的最大值节点
    // 返回去除最大值节点之后的一棵BST
    public Node removeMax(){
        return removeMax(root);
    }

    // 待删除节点的左节点取代待删除节点
    private Node removeMax(Node node) {
        if (node.right == null){
            Node left = node.left;
            node.left = null;
            size --;
            return left;
        }
        // 这一行好好理解下，进来的一棵树，删除之后，衔接删除节点的左节点
        node.right = removeMax(node.right);
        return node;
    }

    // 删除BST中指定值的节点，然后返回删除之后的一棵BST
    public void removeElement(E e){
        if (size == 0)
            throw new IllegalArgumentException(" removeElement failed");
        root = removeElement(root,e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = removeElement(node.left,e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = removeElement(node.right,e);
            return node;
        }
        else {
            // 待删除节点的左子树为空
            if (node.left == null){
                Node right = node.right;
                node.right = null;
                size --;
                return right;
            }

            // 待删除节点的右子树为空
            if (node.right == null){
                Node left = node.left;
                node.left = null;
                size --;
                return left;
            }

            // 1、待删除节点的左右子树都不为空
            // 2、用待删除节点的右子树中最小的节点来代替待删除节点
            // 3、然后删除右子树中那个最小节点

            // 这三行代码，好好领悟
            // 为啥不能写成 Node newNode = removeMin(node); newNode = node.left;
            // 注意这里为啥不要进行size -- ；因为在removeMin中已经对size进行了 -- 了
            Node newNode = new Node(getMin(node.right).e);

            newNode.right = removeMin(node.right);
            newNode.left = node.left;

            node.left = null;
            node.right = null;
            return newNode;
        }
    }


    public static void main(String[] args) {
        BST<Integer> testBST = new BST<>();
        int[] bstValue = {8,5,10,6,9,11};
        for (int i : bstValue) {
            testBST.add(i);
        }
        System.out.println(" 中序遍历 ");
        testBST.inOrder();
    }

}
