package indi.xm.jy.unionfind;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.unionfind
 * @ClassName: QuickUnion
 * @Author: albert.fang
 * @Description: quickUnion：并查集，查：O(h) 并：O(h)
 * @Date: 2021/10/20 19:01
 */
public class QuickUnion implements UF {

    // 索引表示节点id
    // value 表示该节点的父节点id
    private int[] parent;

    public QuickUnion(int size){

        parent = new int[size];

        // 初始化的时候，每个节点指向自身
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 找到节点p所在树的根节点
    // 时间复杂度是 O(h) h 是树的高度
    private int find(int p){
        if (p < 0 || p > parent.length){
            throw new IllegalArgumentException("p is out of bound. ");
        }
        int value = parent[p];
        while (value != parent[p]){
            value = parent[value];
        }
        return value;
    }

    @Override
    public void unionElements(int p, int q) {
        if (!isConnected(p,q)){
            int pRoot = find(p);
            int qRoot = find(q);
            parent[pRoot] = qRoot;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
