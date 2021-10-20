package indi.xm.jy.map;

import indi.xm.jy.utils.FileOperatorUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

/**
 * @author: albert.fang
 * @date: 2021/4/21 15:21
 * @description: bst实现 映射
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private Node root;
    private int size;

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        public Node(K key,V value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(K key,V value){
            this(key,value,null,null);
        }

        public Node(){
            this(null,null);
        }
    }

    public BSTMap(){
        root = null;
        size = 0;
    }

    public Node getNode(K key){
        return getNode(root,key);
    }

    // 判断以node为根节点的BST中是否包含K 值为key的节点（辅助方法，后面的remove,set,get,contains方法可以减少递归，直接调用该方法）
    // 并返回该节点
    private Node getNode(Node node,K key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }
        else if (key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }
        return node;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null){
            size ++;
            return new Node(key,value);
        }
        else if (key.compareTo(node.key) < 0){
            node.left =  add(node.left,key,value);
        }
        else if (key.compareTo(node.key) > 0){
            node.right =  add(node.right,key,value);
        }
        else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
        }
        else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
        }
        else {
            // 这里的node是待删除节点
            // 1、待删除节点左右孩子都为空
            if (node.left == null && node.right == null){
                size --;
                node = null;
            }
            // 2、待删除节点只有左孩子
            else if (node.right == null){
                Node delNode = node;
                node = node.left;
                delNode.left = null;
                size --;
            }
            // 3、待删除节点只有右孩子
            else if (node.left == null){
                Node delNode = node;
                node = delNode.right;
                delNode.right = null;
                size --;
            }
            // 4、待删除节点左右孩子都有
            else {
                Node delNode = node;
                Node maxNode = getMaxNode(delNode.left);
                node = new Node(maxNode.key,maxNode.value);
                node.left = removeMaxNode(delNode.left);
                node.right = delNode.right;
                delNode.left = delNode.right = null;
            }
        }
        return node;
    }

    // 得到BST最小节点
    private Node getMinNode(Node node){
        if (node.left == null){
            return node;
        }
        return getMinNode(node.left);
    }

    // 移除BST最小的节点之后的BST
    private Node removeMinNode(Node node){
        if (node.left == null){
            Node right = node.right;
            node.right = null;
            size --;
            return right;
        }
        node.left = removeMinNode(node.left);
        return node;
    }

    // 得到BST最大的节点
    private Node getMaxNode(Node node){
        if (node.right == null){
            return node;
        }
        return getMaxNode(node.right);
    }

    // 移除BST最大节点之后的BST
    private Node removeMaxNode(Node node){
        if (node.right == null){
            Node left = node.left;
            node.left = null;
            size --;
            return left;
        }
        node.right =  removeMaxNode(node.right);
        return node;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node != null){
            node.value = value;
        }
    }

    private void set(Node node, K key, V value) {
        if (node == null){
            return;
        }
        if (key.compareTo(node.key) == 0){
            node.value = value;
        }
        else if (key.compareTo(node.key) < 0){
            set(node.left,key,value);
        }
        else{
            set(node.right,key,value);
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null){
            return node.value;
        }
        return null;
    }

    private V get(Node node, K key) {
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) == 0){
            return node.value;
        }
        else if (key.compareTo(node.key) < 0){
            return get(node.left,key);
        }
        else{
            return get(node.right,key);
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        LinkedList<String> wordsList = FileOperatorUtils.getWords("data_structure/pride-and-prejudice.txt");
        System.out.printf("pride-and-prejudice words total ： %d\n" ,wordsList.size());
        for (String temp : wordsList) {
            if (bstMap.contains(temp)) {
                bstMap.set(temp,bstMap.get(temp) + 1);
            }
            else {
                bstMap.add(temp,1);
            }
        }
        System.out.printf("不重复的有：%d个\n",bstMap.getSize());
        System.out.println("pride occur times is " + bstMap.get("pride"));
        System.out.println("prejudice occur times is " + bstMap.get("prejudice"));
        System.out.println("\"\" occur times is " + bstMap.get(""));
        System.out.println("them occur times is " + bstMap.get("them"));
        System.out.printf("消耗 %d 毫秒\n", Duration.between(startTime, Instant.now()).toMillis());
        bstMap.remove("pride");
        System.out.println(bstMap.contains("pride"));
        System.out.println(bstMap.get("pride"));
        System.out.println(bstMap.getSize());
    }

}
