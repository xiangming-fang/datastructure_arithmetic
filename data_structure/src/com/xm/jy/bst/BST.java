package com.xm.jy.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/10/29 13:23
 * @description: 二分搜索树的实现
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
    public void preorder(){
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null)
            return;
        // 打印当前根节点的值
        System.out.println(node.e);
        if (node.left != null)
            preorder(node.left);
        if (node.right != null)
            preorder(node.right);
    }

    // 2、BST 的中序遍历
    public void inorder(){
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.println(node.e);
        inorder(node.right);
    }

    // 3、BST 的后序遍历
    public void postorder(){
        postorder(root);
    }

    private void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.right);
        postorder(node.left);
        System.out.println(node.e);
    }

    // 借助栈这种数据结构，实现BST的非递归前序遍历
    public void preorderNR(){
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


    public static void main(String[] args) {
        BST<Integer> testBST = new BST<>();
        int[] bstValue = {3,2,1,4};
        for (int i : bstValue) {
            testBST.add(i);
        }
        System.out.println(" 前序遍历 ");
        testBST.preorder();
        System.out.println(" 非递归的前序遍历 ");
        testBST.preorderNR();
        System.out.println(" 中序遍历 ");
        testBST.inorder();
        System.out.println(" 后序遍历 ");
        testBST.postorder();
        System.out.println(" 层次遍历 ");
        testBST.levelOrder();
    }

}
