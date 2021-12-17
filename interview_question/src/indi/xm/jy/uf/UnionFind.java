package indi.xm.jy.uf;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.uf
 * @ClassName: UnionFind
 * @Author: albert.fang
 * @Description: 并查集
 * @Date: 2021/12/17 15:02
 */
public class UnionFind<T> {

    private class Node<T> {
        private T value;

        Node(T value){
            this.value = value;
        }
    }

    // key -> 类型值，value -> 包过类型值的node
    private HashMap<T,Node> nodeMap = new HashMap<>();

    // key -> 顶部节点，value -> 这个顶部节点里包含多少个节点
    private HashMap<Node,Integer> countMap = new HashMap<>();

    // key -> 节点，value -> 节点所对应的父亲节点
    private HashMap<Node,Node> parentMap = new HashMap<>();

    public UnionFind(List<T> list){
        for (T t : list) {
            Node node = new Node(t);
            nodeMap.put(t,node);
            countMap.put(node,1);
            parentMap.put(node,nodeMap.get(t));
        }
    }

    public UnionFind(T[] arr){
        for (T t : arr) {
            Node node = new Node(t);
            nodeMap.put(t,node);
            countMap.put(node,1);
            parentMap.put(node,nodeMap.get(t));
        }
    }

    // 判断 a 和 b 是否在同一个集合中
    public boolean isSameSet(T a, T b){
        // 判断黑盒中是否有a,和 b，如果其中一个没有，那么不用说，a,b肯定不在同一个集合中
        if (!nodeMap.containsKey(a) || !nodeMap.containsKey(b)){
            return false;
        }
        // 如果 a，b都存在于nodeMap中，那么判断 a 所在集合所表示的 顶部节点 和 b所在集合所表示的顶部节点是否是同一个
        return findTopNode(nodeMap.get(a)) == findTopNode(nodeMap.get(b));
    }

    // 将 a 和 b 合并到一个集合上
    public void union(T a,T b){
        // 所有集合中并没有 a，或者 b
        if (!nodeMap.containsKey(a) || !nodeMap.containsKey(b)) {
            return;
        }

        // 合并之前要保证,a，b现在不在同一个集合上
        if (findTopNode(nodeMap.get(a)) != findTopNode(nodeMap.get(b))){
            Node aTopNode = findTopNode(nodeMap.get(a));
            Node bTopNode = findTopNode(nodeMap.get(b));

            // 并查集优化一：按秩合并
            // 判断 a 和 b 所处的集合 哪个节点更多，节点多的不用动
            Node bigNode = countMap.get(aTopNode) >= countMap.get(bTopNode) ? aTopNode : bTopNode;
            Node smallNode = countMap.get(aTopNode) < countMap.get(bTopNode) ? aTopNode : bTopNode;

            // 将节点数更少的集合挂接在节点数更多的集合
            parentMap.put(smallNode,bigNode);
            countMap.put(bigNode,countMap.get(bigNode) + countMap.get(smallNode));
            // cong countMap 中移除小节点的记录
            countMap.remove(smallNode);
        }

    }

    private Node findTopNode(Node cur) {

        // 为啥这里要一个stack，是为了更好的扁平化管理
        Stack<Node> stack = new Stack<>();

        // 外面一个while循环比较好理解
        // 简单粗暴点理解 就是我的父亲节点是我自己，那么我就是顶级节点了，不必再找了；否则 给我一直找
        while (cur != parentMap.get(cur)){
            stack.push(cur);
            cur = parentMap.get(cur);
        }

        // 并查集优化二：路径压缩
        // 将stack里的节点，也就是 入参 cur 到 顶部节点这条路径的所有节点直接挂接在 顶部节点上。
        // 到这里 cur 就已经是顶部节点了
        while (!stack.isEmpty()){
            // 直接将路径上的节点挂接在顶部节点cur上
            parentMap.put(stack.pop(),cur);
        }

        return cur;
    }
}
