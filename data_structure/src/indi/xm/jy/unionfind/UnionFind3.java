package indi.xm.jy.unionfind;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.unionfind
 * @ClassName: QuickUnion
 * @Author: albert.fang
 * @Description: UnionFind：并查集，查：O(h) 并：O(h)
 * 基于size的优化
 * 优化点：在union的过程中，让节点所处树的节点个数少的根节点指向多的那个根节点
 * @Date: 2021/10/20 19:01
 */
public class UnionFind3 implements UF {

    // 索引表示节点id
    // value 表示该节点的父节点id
    private int[] parent;

    // sz[i] 表示以i为根节点的集合中元素个数
    private int[] sz;

    public UnionFind3(int size){

        parent = new int[size];
        sz = new int[size];

        // 初始化的时候，每个节点指向自身
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void unionElements(int p, int q) {
        if (!isConnected(p,q)){
            int pRoot = find(p);
            int qRoot = find(q);
            if (sz[pRoot] < sz[qRoot]){
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[qRoot];
            }else {
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
